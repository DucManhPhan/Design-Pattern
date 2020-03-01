package com.manhpd.false_sharing;

public class FalseSharing {
    public static int NUM_THREADS_MAX = 4;
    public final static long ITERATIONS = 50_000_000L;

    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unPaddedLongs;

    public static final class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6;
        public volatile long value = 0L;
        public long q11, q12, q13, q14, q15, q16;
    }

    public static final class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLongs.length; ++i) {
            paddedLongs[i] = new VolatileLongPadded();
        }

        unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLongs.length; ++i) {
            unPaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main(String[] args) throws Exception {
        runBenchmark();
    }

    private static void runBenchmark() throws InterruptedException {
        long begin, end;

        for (int n = 1; n <= NUM_THREADS_MAX; ++n) {
            Thread[] threads = new Thread[n];

            // Padded
            for (int i = 0; i < threads.length; ++i) {
                threads[i] = new Thread(createdPaddedRunnable(i));
            }

            begin = System.currentTimeMillis();
            for (Thread t : threads) { t.start(); }
            for (Thread t : threads) { t.join(); }

            end = System.currentTimeMillis();
            System.out.printf("Padded # threads %d - T = %dms\n", n, end - begin);

            // Unpadded
            for (int i = 0; i < threads.length; ++i) {
                threads[i] = new Thread(createdUnPaddedRunnable(i));
            }

            begin = System.currentTimeMillis();
            for (Thread t : threads) { t.start(); }
            for (Thread t : threads) { t.join(); }

            end = System.currentTimeMillis();
            System.out.printf("UnPadded # threads %d - T = %dms\n", n, end - begin);
        }
    }

    private static Runnable createdUnPaddedRunnable(final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                unPaddedLongs[k].value = i;
            }
        };
    }

    private static Runnable createdPaddedRunnable(final int k) {
        Runnable paddedTouch = () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                paddedLongs[k].value = i;
            }
        };

        return paddedTouch;
    }

}
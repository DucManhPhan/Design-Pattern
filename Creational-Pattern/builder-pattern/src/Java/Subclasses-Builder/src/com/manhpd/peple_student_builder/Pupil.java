package com.manhpd.peple_student_builder;

public class Pupil extends Student {

    private String something;

    public Pupil(Builder builder) {
        super(builder);
        this.something = builder.something;
    }

    @Override
    public String toString() {
        return super.toString() + ", something: " + this.something;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Student.Builder {
        private String something;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder something(String something) {
            this.something = something;
            return this;
        }

        public Pupil build() {
            return new Pupil(this);
        }
    }
}

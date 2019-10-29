package com.manhpd.shape_builder.other_version;

public abstract class X {

    protected int foo;

    protected  int bar;

    protected static abstract class Builder<T extends X, B extends Builder<T, B>> {
        protected T obj;
        protected B thisObj;

        public Builder() {
            this.obj = createObj();
            this.thisObj = getThis();
        }

        public B withFoo(int foo) {
            obj.foo = foo;
            return thisObj;
        }

        public B withBar(int bar) {
            obj.bar = bar;
            return thisObj;
        }

        public T build() {
            return this.obj;
        }

        protected abstract T createObj();

        protected abstract  B getThis();
    }

    protected X() {
        // nothing to do
    }

    public int getFoo() {
        return this.foo;
    }

    public int getBar() {
        return this.bar;
    }

}

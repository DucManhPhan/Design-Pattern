package com.manhpd.shape_builder.other_version;

public class Y extends X {

    private int taz;

    public static class Builder extends X.Builder<Y, Y.Builder> {
        public Builder withTaz(int taz) {
            this.obj.taz = taz;
            return this.thisObj;
        }

        protected Y createObj() {
            return new Y();
        }

        protected Builder getThis() {
            return this;
        }
    }

    protected Y() {
        // nothing to do
    }

    public int getTaz() {
        return this.taz;
    }

}

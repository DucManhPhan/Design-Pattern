package org.manhpd.domain;

import lombok.Getter;

public class AggregateRoot {

    @Getter
    private long version;

    public AggregateRoot() {
        this(0);
    }

    public AggregateRoot(int version) {
        this.version = version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}

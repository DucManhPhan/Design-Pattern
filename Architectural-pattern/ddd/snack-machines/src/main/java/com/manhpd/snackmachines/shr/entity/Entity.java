package com.manhpd.snackmachines.shr.entity;

import java.util.Objects;

public class Entity {

    protected long id;

    @Override
    public boolean equals(Object o) {
        Entity other = (Entity) o;

        if (other == null) {
            return false;
        }

        if (this == other) {    // reference equality
            return true;
        }

        if (!this.getClass().equals(other.getClass())) {
            return false;
        }

        if (this.id == 0 || other.getId() == 0) {
            return false;
        }

        return this.id == other.getId();    // identifier equality
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.manhpd.context;

import com.manhpd.state.State;


/**
 * Context is handled by Client
 * Client do not access directly to State of object.
 *
 */
public class Context {

    private State state = null;

    // Context also contains data for all states, they are sharing the same Context.

    public Context() {
        // nothing to do
    }

    public void request() {
        this.state.handle(this);
    }

    public void setState(State state) {
        this.state = state;
    }

}

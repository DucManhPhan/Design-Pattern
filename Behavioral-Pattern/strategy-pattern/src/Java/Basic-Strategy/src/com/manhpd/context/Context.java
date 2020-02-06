package com.manhpd.context;

import com.manhpd.behavior.IBehavior;

public class Context {

    private IBehavior behavior;

    public Context(IBehavior behavior) {
        this.behavior = behavior;

}
    public void execute() {
        behavior.doAction();
    }

}

package com.manhpd.state;

import com.manhpd.context.Context;

public class ConcreteState1 implements State {

    @Override
    public void handle(Context ctx) {
        System.out.println("Concrete State 1 is handling.");
    }
}

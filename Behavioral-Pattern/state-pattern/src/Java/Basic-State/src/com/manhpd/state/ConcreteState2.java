package com.manhpd.state;

import com.manhpd.context.Context;

public class ConcreteState2 implements State {

    @Override
    public void handle(Context ctx) {
        System.out.println("Concrete State 2 is handling.");
    }
}

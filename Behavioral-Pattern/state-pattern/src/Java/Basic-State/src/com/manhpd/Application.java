package com.manhpd;

import com.manhpd.context.Context;
import com.manhpd.state.ConcreteState1;
import com.manhpd.state.ConcreteState2;

public class Application {

    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setState(new ConcreteState1());

        ctx.request();

        ctx.setState(new ConcreteState2());
        ctx.request();
    }

}

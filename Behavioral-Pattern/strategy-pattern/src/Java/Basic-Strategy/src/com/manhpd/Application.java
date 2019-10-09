package com.manhpd;

import com.manhpd.behavior.Behavior1;
import com.manhpd.behavior.IBehavior;
import com.manhpd.context.Context;

public class Application {

    public static void main(String[] args) {
        IBehavior behavior = new Behavior1();
        Context context = new Context(behavior);

        context.execute();
    }

}

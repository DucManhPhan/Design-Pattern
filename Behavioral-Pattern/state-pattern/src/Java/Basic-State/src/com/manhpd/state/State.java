package com.manhpd.state;

import com.manhpd.context.Context;

public interface State {

    void handle(Context ctx);

}

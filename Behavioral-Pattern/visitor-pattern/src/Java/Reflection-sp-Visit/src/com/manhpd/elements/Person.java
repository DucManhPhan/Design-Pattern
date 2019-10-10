package com.manhpd.elements;

import com.manhpd.visitor.Visitor;

public interface Person {

    void accept(Visitor visitor);

}

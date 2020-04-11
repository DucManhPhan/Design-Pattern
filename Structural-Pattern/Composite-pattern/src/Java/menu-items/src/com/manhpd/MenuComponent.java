package com.manhpd;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

    protected String name;

    protected String url;

    protected List<MenuComponent> menuComponents = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public abstract String toString();

    public String print(MenuComponent menuComponent) {
        StringBuilder builder = new StringBuilder();
        builder.append(": ");
        builder.append(this.url);
        builder.append("\n");

        return builder.toString();
    }

    public MenuComponent add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature not implemented at this level");
    }

}

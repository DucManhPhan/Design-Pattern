package com.manhpd;

import java.util.Iterator;

public class Menu extends MenuComponent {

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(print(this));

        Iterator<MenuComponent> itr = this.menuComponents.iterator();
        while (itr.hasNext()) {
            MenuComponent menuComponent = itr.next();
            builder.append(menuComponent.toString());
        }

        return builder.toString();
    }

    @Override
    public MenuComponent add(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
        return menuComponent;
    }

    @Override
    public MenuComponent remove(MenuComponent menuComponent) {
        this.menuComponents.remove(menuComponent);
        return menuComponent;
    }
}

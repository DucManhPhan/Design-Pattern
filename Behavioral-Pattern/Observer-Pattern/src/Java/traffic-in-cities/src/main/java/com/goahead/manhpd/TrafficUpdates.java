package com.goahead.manhpd;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class TrafficUpdates implements PropertyChangeListener {

    private List<String> updates = new ArrayList<>();

    public void getUpdates() {
        this.updates.forEach(System.out::println);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.updates.add((String) evt.getNewValue());
    }
}

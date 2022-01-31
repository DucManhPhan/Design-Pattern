package com.goahead.manhpd;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaFeed implements PropertyChangeListener {

    private List<String> statuses = new ArrayList<>();

    public void printStatuses() {
        this.statuses.forEach(System.out::println);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.statuses.add((String) event.getNewValue());
    }
}

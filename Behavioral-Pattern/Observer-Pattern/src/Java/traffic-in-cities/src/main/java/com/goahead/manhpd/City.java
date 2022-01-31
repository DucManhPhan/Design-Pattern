package com.goahead.manhpd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class City {

    private String trafficUpdate = "";

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void updateTraffic(String trafficUpdate) {
        this.support.firePropertyChange("traffic", this.trafficUpdate, trafficUpdate);
        this.trafficUpdate = trafficUpdate;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

}

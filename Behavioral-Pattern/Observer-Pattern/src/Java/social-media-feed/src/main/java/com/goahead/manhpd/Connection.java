package com.goahead.manhpd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Connection {

    private String status = "";

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setStatus(String status) {
        this.support.firePropertyChange("status", this.status, status);
        this.status = status;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

}

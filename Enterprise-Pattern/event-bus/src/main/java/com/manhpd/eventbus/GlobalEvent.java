package com.manhpd.eventbus;

import lombok.Getter;

import java.util.*;

public class GlobalEvent {

    @Getter
    private final String eventName;

    private final Map<String, String> data = new HashMap<>();

    public GlobalEvent(String eventName) {
        this.eventName = eventName;
    }

    public void setData(String key, String value) {
        this.data.put(key, value);
    }

    public void setString(String key, String value) {
        this.setData(key, value);
    }

    public void setBoolean(String key, boolean value) {
        this.setData(key, Boolean.toString(value));
    }

    public void setInteger(String key, int value) {
        this.setData(key, Integer.toString(value));
    }

    public void setLong(String key, long value) {
        this.setData(key, Long.toString(value));
    }

    public void setDouble(String key, double value) {
        this.setData(key, Double.toString(value));
    }

    public void setDateTime(String key, Date value) {
        this.setData(key, Long.toString(value.getTime()));
    }

    public void setDateTime(String key, Calendar value) {
        this.setData(key, Long.toString(value.getTimeInMillis()));
    }

//    public void setDateTime(String key, DateTimePrimitiveValue<?> value) {
//        this.setData(key, Long.toString(value.timeInMillis()));
//    }
//
//    public void setDate(String key, DatePrimitiveValue<?> value) {
//        this.setData(key, Long.toString(value.timeInMillis()));
//    }

    public String getData(String key) {
        return this.data.get(key);
    }

    public String getString(String key) {
        return this.getData(key);
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(this.getData(key));
    }

    public int getInteger(String key) {
        return Integer.parseInt(this.getData(key));
    }

    public long getLong(String key) {
        return Long.parseLong(this.getData(key));
    }

    public double getDouble(String key) {
        return Double.parseDouble(this.getData(key));
    }

    public Date getDate(String key) {
        return new Date(Long.parseLong(this.getData(key)));
    }

    public Calendar getCalendar(String key) {
        Calendar value = Calendar.getInstance();
        value.setTimeInMillis(Long.parseLong(this.getData(key)));
        return value;
    }

//    public GeneralDate getGeneralDate(String key) {
//        return new GeneralDate(this.getCalendar(key));
//    }
//
//    public GeneralDateTime getGeneralDateTime(String key) {
//        return new GeneralDateTime(this.getCalendar(key));
//    }

    public Set<String> getDataKeySet() {
        return this.data.keySet();
    }

}

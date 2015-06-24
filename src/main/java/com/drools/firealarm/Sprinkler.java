package com.drools.firealarm;

public class Sprinkler {
    private final Room room;
    private boolean on = false;

    public Sprinkler(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Room getRoom() {
        return room;
    }
}

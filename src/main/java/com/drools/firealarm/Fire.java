package com.drools.firealarm;

public class Fire {
    private final Room room;

    public Fire(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}

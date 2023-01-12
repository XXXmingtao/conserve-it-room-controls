package org.conserve;

import java.util.ArrayList;

public class CommonRoom extends Rooms{
    private String roomType;

    public CommonRoom(String roomType, int roomID, boolean heaterStatus, boolean airConStatus) {
        this.roomType = roomType;
        this.setRoomID(roomID);
        this.setHeaterStatus(false);
        this.setAirConStatus(false);
    }

    public String getRoomType() {

        return roomType;
    }

    public String toString() {
        return String.format("Room Type: %s - Current Temperature: %.1f °C - Heater: %b - Air Conditioner: %b", this.roomType, this.getTemperature(), this.isHeaterStatus(), this.isAirConStatus());
    }
}

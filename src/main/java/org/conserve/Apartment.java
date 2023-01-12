package org.conserve;
import java.util.Random;

public class Apartment extends Rooms {

    private String ownerName;

    public Apartment(String owner, int roomID, boolean heaterStatus, boolean airConStatus) {
        this.ownerName = owner;

        this.setRoomID(roomID);
        float tem = (float)Math.floor(Math.random() * (40 - 10 + 1) + 10);
        this.setTemperature(tem);
        this.setHeaterStatus(heaterStatus);
        this.setAirConStatus(airConStatus);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String toString() {
        return String.format("AptNumber: %s - Current Temperature: %.1f °C - Heater: %b - Air Conditioner: %b", this.getRoomID(), this.getTemperature(), this.isHeaterStatus(), this.isAirConStatus());
    }
}

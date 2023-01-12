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

}

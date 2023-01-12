package org.conserve;

public class Apartment extends Rooms {

    private String ownerName;

    public Apartment(String owner, int roomID, float temperature, boolean heaterStatus, boolean airConStatus) {
        this.ownerName = owner;
        this.setRoomID(roomID);
        this.setTemperature(temperature);
        this.setHeaterStatus(heaterStatus);
        this.setAirConStatus(airConStatus);
    }

}

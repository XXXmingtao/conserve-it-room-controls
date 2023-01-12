package org.conserve;

abstract class Rooms {
    private int roomID;
    private float temperature;
    private boolean heaterStatus = false;
    private boolean airConStatus = false;


    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public float getTemperature(){
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public boolean isHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(boolean heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public boolean isAirConStatus() {
        return airConStatus;
    }

    public void setAirConStatus(boolean airConStatus) {
        this.airConStatus = airConStatus;
    }
}

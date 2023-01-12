package org.conserve;

public class CommonRoom extends Rooms{
    private String roomType;

    public CommonRoom(String roomType, int roomID, boolean heaterStatus, boolean airConStatus) {
        this.roomType = roomType;
        this.setRoomID(roomID);
        this.setHeaterStatus(false);
        this.setAirConStatus(true);
    }

    public String getRoomType() {
        return roomType;
    }
}

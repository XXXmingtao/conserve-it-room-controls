package org.conserve;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Apartment> apartments;
    private List<CommonRoom> commonRooms;
    private ArrayList<String> roomTypes = new ArrayList<String>(3);
    private float requestedTemperature;

    public Building() {
        this.apartments = new ArrayList<Apartment>();
        this.commonRooms = new ArrayList<CommonRoom>();
        this.requestedTemperature = 20.0f;
        roomTypes.add("GYM");
        roomTypes.add("LIBRARY");
        roomTypes.add("LAUNDRY");
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void addCommonRoom(CommonRoom commonRoom) {
        commonRooms.add(commonRoom);
    }

    public List<Apartment> getAllApartments() {
        return this.apartments;
    }

    public List<CommonRoom> getAllCommonRooms() {
        return this.commonRooms;
    }

    public ArrayList<String> getRoomTypes() {
        return this.roomTypes;
    }

    public void displayAptStatus() {
        for(int i = 0 ; i < apartments.size() ; i++) {
            System.out.println(apartments.get(i));
        }
    }

    public void displayCommonRoomStatus() {

        for(CommonRoom commonRoom : this.commonRooms) {
            System.out.println(commonRoom);
        }
    }

    public float getRequestedTemperature() {
        return this.requestedTemperature;
    }

    public void setRequestedTemperature(float temperature) {
        this.requestedTemperature = temperature;
    }

}

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

    //Evaluate temperature for apartment
    public void evaluateAptTemperature() {
        for(Apartment apt : this.getAllApartments()){
            if(apt.getTemperature() < this.getRequestedTemperature() - 2) {
                apt.setHeaterStatus(true);
                apt.setAirConStatus(false);
            }
            else if (apt.getTemperature() > this.getRequestedTemperature() + 2) {
                apt.setHeaterStatus(false);
                apt.setAirConStatus(true);
            }
            else {
                apt.setHeaterStatus(false);
                apt.setAirConStatus(false);
            }
        }
    }

    //Evaluate temperature for common Rooms
    public void evaluateCommonRoomTemperature() {
        for(CommonRoom room : this.getAllCommonRooms()) {
            if(room.getTemperature() < this.getRequestedTemperature() - 2) {
                room.setHeaterStatus(true);
                room.setAirConStatus(false);
            }
            else if(room.getTemperature() > this.getRequestedTemperature() + 2) {
                room.setHeaterStatus(false);
                room.setAirConStatus(true);
            } else {
                room.setHeaterStatus(false);
                room.setAirConStatus(false);
            }
        }
    }

}

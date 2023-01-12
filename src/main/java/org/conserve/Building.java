package org.conserve;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Apartment> apartments;
    private List<CommonRoom> commonRooms;
    private float requestedTemperature;

    public Building() {
        this.apartments = new ArrayList<Apartment>();
        this.commonRooms = new ArrayList<CommonRoom>();
        this.requestedTemperature = 20.0f;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void addCommonRoom(CommonRoom commonRoom) {
        commonRooms.add(commonRoom);
    }

    public void setRequestedTemperature(float temperature) {
        this.requestedTemperature = temperature;
    }

}

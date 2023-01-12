package org.conserve;

public class Main {
    public static void main(String[] args) {
        Apartment apt1 = new Apartment("Mingtao", 101, false, false);
        Apartment apt2 = new Apartment("Mingtao", 102, false, false);

        CommonRoom room1 = new CommonRoom("Gym", 1, false, false);

        Building building = new Building();
        building.addApartment(apt1);
        building.addApartment(apt2);

        building.addCommonRoom(room1);

        for(Apartment apt : building.getAllApartments()){
            if(apt.getTemperature() < building.getRequestedTemperature()) {
                apt.setHeaterStatus(true);
                apt.setAirConStatus(false);
            }
            else if (apt.getTemperature() > building.getRequestedTemperature()) {
                apt.setHeaterStatus(false);
                apt.setAirConStatus(true);
            }
        }
        System.out.println("All Apartment Status has shown below: ");
        building.displayAptStatus();

        System.out.println();


        for(CommonRoom room : building.getAllCommonRooms()) {
            if(room.getTemperature() < building.getRequestedTemperature()) {
                room.setHeaterStatus(true);
                room.setAirConStatus(false);
            }
            else if(room.getTemperature() > building.getRequestedTemperature()) {
                room.setHeaterStatus(false);
                room.setAirConStatus(true);
            }
        }

        System.out.println("All common room status has shown below: ");
        building.displayCommonRoomStatus();
    }

}
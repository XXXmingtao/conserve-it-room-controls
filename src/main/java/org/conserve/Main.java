package org.conserve;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Apartment apt1 = new Apartment("Mingtao", 101, false, false);
        Apartment apt2 = new Apartment("Mingtao", 102, false, false);

        CommonRoom room1 = new CommonRoom("Gym", 1, false, false);

        Building building = new Building();
        building.addApartment(apt1);
        building.addApartment(apt2);
        building.addCommonRoom(room1);
        building.setRequestedTemperature(25.0f);
        //User Menu
        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Welcome to the room control system - Aurora! Please make selection below to further interact...");
            System.out.println(" 1 - Display all monitored apartments");
            System.out.println(" 2 - Display all monitored common room");
            System.out.println(" 3 - Add new apartment to the building");
            System.out.println(" 4 - Add new common room to the building");
            System.out.println(" 5 - Start monitoring");
            System.out.println("You enter: ");

            try {
                String user_input = scanner.nextLine();
                int selection = Integer.parseInt(user_input);

                if(selection == 1) {
                    building.displayAptStatus();
                }

                if(selection == 2){
                    building.displayCommonRoomStatus();
                }

                if(selection == 3){
                    System.out.println("Please enter the new apartment info in the following format: owner-roomID");
                    String new_partment = scanner.nextLine();

                    String[] parts = new_partment.split("-");
                    building.addApartment(new Apartment(parts[0], Integer.parseInt(parts[1]), false, false));
                }

                if(selection == 5) {
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


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
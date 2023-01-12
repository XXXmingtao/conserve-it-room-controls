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

        Scanner scanner = new Scanner(System.in);

        while(true) {
            //User Menu
            System.out.println("Welcome to the room control system - Aurora! Please make selection below to further interact...");
            System.out.println(" 1 - Display all monitored apartments");
            System.out.println(" 2 - Display all monitored common room");
            System.out.println(" 3 - Add new apartment to the building");
            System.out.println(" 4 - Add new common room to the building");
            System.out.println(" 5 - Start monitoring");
            System.out.println("Your input >> ");

            try {
                String user_input = scanner.nextLine();
                int selection = Integer.parseInt(user_input);

                if(selection == 1) {
                    building.displayAptStatus();
                }

                if(selection == 2){
                    building.displayCommonRoomStatus();
                }

                //Function to add new apartment
                if(selection == 3){
                    Boolean errorFlag = false;
                    System.out.println("Please enter the new apartment info in the following format: owner-roomID");
                    System.out.println();
                    String new_apartment = scanner.nextLine();
                    try {
                        String[] aptInfo = new_apartment.split("-");
                        for(Apartment apartment : building.getAllApartments()) {
                            if(apartment.getRoomID() == Integer.parseInt(aptInfo[1])) {
                                System.out.println(String.format("Room ID %s has already exist", aptInfo[1]));
                                System.out.println();
                                errorFlag = true;
                            }
                        }
                        if(errorFlag == false){
                            building.addApartment(new Apartment(aptInfo[0], Integer.parseInt(aptInfo[1]), false, false));
                        }
                    } catch (Exception e) {
                        System.out.println("Please check your input is in right format... e.g. 100-Ming");
                    }
                }

                //Function to add new Common Room
                if(selection == 4){
                    boolean errorFlag = false;
                    System.out.println("Please enter the new apartment info in the following format: roomType-roomID");
                    System.out.println();
                    String newRoom = scanner.nextLine();
                    try {

                        String [] roomInfo = newRoom.split("-");
                        for(CommonRoom commonRoom : building.getAllCommonRooms()) {
                            if(commonRoom.getRoomID() == Integer.parseInt(roomInfo[1])){
                                System.out.println(String.format("Room ID %s has already exist", roomInfo[1]));
                                System.out.println();
                                errorFlag = true;
                            }
                        }
                        if(errorFlag == false){
                            building.addCommonRoom(new CommonRoom(roomInfo[0], Integer.parseInt(roomInfo[1]),false,false));
                        }

                    } catch (Exception e){

                        System.out.println("Please check your input is in right format... e.g. Library-3");
                    }

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
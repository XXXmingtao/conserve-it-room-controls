package org.conserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    Apartment apt1;
    CommonRoom gym;
    Building building;


    @BeforeEach
    void setUp() {
        apt1 = new Apartment("Mingtao", 101, false, false);
        gym = new CommonRoom("Gym", 1, false, false);
        building = new Building();
        building.addApartment(apt1);
        building.addCommonRoom(gym);
    }

    @Test
    @DisplayName("Heater will be turned on if current temperature is less than 2 degree to the requested temperature. ")
    void evaluateAptTemperature_heater() {
        //Evaluate heater function
        apt1.setTemperature(25);
        building.setRequestedTemperature(28);
        building.evaluateAptTemperature();

        assertTrue(apt1.isHeaterStatus(), "Heater occurs problem. ");

    }

    @Test
    @DisplayName("Air conditioner will turn on if current temperature is more than 2 degree to the requested temperature. ")
    void evaluateAptTemperature_airCon() {
        //evaluate air con function
        apt1.setTemperature(25);
        building.setRequestedTemperature(22);
        building.evaluateAptTemperature();

        assertTrue(apt1.isAirConStatus(), "Air conditioner occurs problem. ");
    }

    @Test
    @DisplayName("Air conditioner and heater will response if current temperature is beyond the range of 2 degrees")
    void evaluateAptTemperature_both_in_changing_temperature() {
        //Heater status
        apt1.setTemperature(20);
        building.setRequestedTemperature(27);

        building.evaluateAptTemperature();

        assertFalse(apt1.isAirConStatus());
        assertTrue(apt1.isHeaterStatus());

        while(apt1.getTemperature() != 26){
            apt1.setTemperature(apt1.getTemperature()+1);
        }
        building.evaluateAptTemperature();

        assertFalse(apt1.isHeaterStatus());
        assertFalse(apt1.isAirConStatus());

        //Air con status check
        apt1.setTemperature(34);
        building.evaluateAptTemperature();

        assertTrue(apt1.isAirConStatus());
        assertFalse(apt1.isHeaterStatus());

        while(apt1.getTemperature() != 28) {
            apt1.setTemperature(apt1.getTemperature()-1);
        }

        building.evaluateAptTemperature();

        assertFalse(apt1.isHeaterStatus());
        assertFalse(apt1.isAirConStatus());


    }
}
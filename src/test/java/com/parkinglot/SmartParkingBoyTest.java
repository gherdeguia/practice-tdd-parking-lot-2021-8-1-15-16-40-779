package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    void should_return_parking_ticket_when_park_car_given_two_parking_lot_and_park_car_on_parking_lot_with_more_available_space() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,6),
                        new ParkingLot(10,1)
                );
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);

        //then
        assertNotNull(parkingTicket01);
    }
}

package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_park_car_given_two_parking_lot_and_park_car_on_parking_lot_with_more_available_space_ratio() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(15,12),
                        new ParkingLot(20,15)
                );

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        ParkingTicket parkingTicket01 = superSmartParkingBoy.parkCar(firstCar);

        //then
        assertNotNull(parkingTicket01);
    }
}

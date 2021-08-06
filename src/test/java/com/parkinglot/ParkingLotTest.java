package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_parked_car_given_parking_lot_and_car() {
        //when
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //given
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }
}

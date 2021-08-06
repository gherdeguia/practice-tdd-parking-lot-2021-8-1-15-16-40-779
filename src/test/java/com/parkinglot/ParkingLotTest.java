package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void should_return_car_when_return_parking_ticket_given_parking_lot_and_parking_ticket() {
        //when
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //given
        Car returnedCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, returnedCar);
    }
}

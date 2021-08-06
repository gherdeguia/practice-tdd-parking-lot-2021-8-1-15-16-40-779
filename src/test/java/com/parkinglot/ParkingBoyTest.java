package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parked_car_given_parking_lot_and_car() {
        //when
        ParkingBoy pBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();


        //given
        ParkingTicket parkingTicket = ParkingBoy.parkCar(car);

        //then
        assertNotNull(parkingTicket);
    }
}

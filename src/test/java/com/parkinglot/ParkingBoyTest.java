package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parked_car_given_parking_lot_and_car() {
        //when
        ParkingBoy pBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();

        //given
        ParkingTicket parkingTicket = pBoy.parkCar(car);;

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_correct_car_when_park_two_cars_given_parking_lot_and_two_parking_tickets() {
        //when
        ParkingBoy pBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = pBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = pBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = pBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = pBoy.fetchCar(parkingTicket02);

        //then
        assertEquals(firstCar, returnedCar01);
        assertEquals(secondCar, returnedCar02);
    }
}

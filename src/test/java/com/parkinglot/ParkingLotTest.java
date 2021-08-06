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
        ParkingTicket parkingTicket = parkingLot.parkCar(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_return_parking_ticket_given_parking_lot_and_parking_ticket() {
        //when
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.parkCar(car);

        //given
        Car returnedCar = parkingLot.fetchCar(parkingTicket);

        //then
        assertEquals(car, returnedCar);
    }

    @Test
    void should_return_correct_car_when_park_two_cars_given_parking_lot_and_two_parking_tickets() {
        //when
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = parkingLot.parkCar(firstCar);
        ParkingTicket parkingTicket02 = parkingLot.parkCar(secondCar);

        //given
        Car returnedCar01 = parkingLot.fetchCar(parkingTicket01);
        Car returnedCar02 = parkingLot.fetchCar(parkingTicket02);

        //then
        assertEquals(firstCar, returnedCar01);
        assertEquals(secondCar, returnedCar02);
    }
}

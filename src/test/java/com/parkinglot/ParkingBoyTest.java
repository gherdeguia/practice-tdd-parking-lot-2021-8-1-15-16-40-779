package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_unrecognized_ticket() {
        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = parkingBoy.parkCar(firstCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetchCar(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_used_parking_ticket() {
        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = parkingBoy.parkCar(firstCar);
        parkingBoy.fetchCar(parkingTicket01);

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetchCar(parkingTicket01));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_full_capacity_parking() {
        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car();

        //given
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.parkCar(firstCar));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}

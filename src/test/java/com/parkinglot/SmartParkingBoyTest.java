package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

    @Test
    void should_return_parking_ticket_when_park_car_given_two_parking_lot_and_park_car_on_parking_lot_with_more_available_space() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,6),
                        new ParkingLot(10,1)
                );
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);

        //then
        assertNotNull(parkingTicket01);
    }

    @Test
    void should_return_correct_car_when_park_two_cars_given_parking_lot_and_two_parking_tickets() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = smartParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = smartParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = smartParkingBoy.fetchCar(parkingTicket02);

        //then
        assertEquals(firstCar, returnedCar01);
        assertEquals(secondCar, returnedCar02);
    }

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_unrecognized_ticket() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetchCar(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_used_parking_ticket() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        smartParkingBoy.fetchCar(parkingTicket01);

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetchCar(parkingTicket01));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_parking_lot_and_full_capacity_parking() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,9)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> smartParkingBoy.parkCar(firstCar));

        //then
        assertEquals("No available position.", exception.getMessage());
    }

    //STORY 4

    @Test
    void should_return_ticket_when_parked_car_given_two_parking_lots_and_car() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1),
                        new ParkingLot(10,0)
                );

        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //given
        ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_correct_car_when_park_two_cars_given_two_parking_lot_and_two_parking_tickets() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1),
                        new ParkingLot(10,0)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = smartParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = smartParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = smartParkingBoy.fetchCar(parkingTicket02);

        //then
        assertEquals(firstCar, returnedCar01);
        assertEquals(secondCar, returnedCar02);
    }

    @Test
    void should_return_parking_ticket_when_park_car_given_two_parking_lot_and_full_parking_on_parking_lot_1() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,10),
                        new ParkingLot(10,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);


        //then
        assertNotNull(parkingTicket01);
    }

    @Test
    void should_return_car_when_fetch_cars_given_two_parking_lots_and_two_parking_tickets() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,9),
                        new ParkingLot(10,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = smartParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = smartParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = smartParkingBoy.fetchCar(parkingTicket02);


        //then
        assertEquals(firstCar, returnedCar01);
        assertEquals(secondCar, returnedCar02);
    }

    @Test
    void should_return_error_message_when_fetch_car_given_two_parking_lots_and_unrecognized_ticket() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,9),
                        new ParkingLot(10,1)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetchCar(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_two_parking_lots_and_used_parking_ticket() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,1),
                        new ParkingLot(10,5)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = smartParkingBoy.parkCar(firstCar);
        smartParkingBoy.fetchCar(parkingTicket01);

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetchCar(parkingTicket01));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_park_car_given_two_parking_lots_and_no_available_parking_space() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(10,10),
                        new ParkingLot(10,10)
                );
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> smartParkingBoy.parkCar(firstCar));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}

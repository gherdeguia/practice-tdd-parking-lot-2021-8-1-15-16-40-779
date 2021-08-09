package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    @Test
    void should_return_ticket_when_parked_car_given_parking_lot_and_car() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1)
                );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        //given
        ParkingTicket parkingTicket = standardParkingBoy.parkCar(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_correct_car_when_park_two_cars_given_parking_lot_and_two_parking_tickets() {
        //when
        List<ParkingLot> parkingLots =
                Arrays.asList(
                        new ParkingLot(9,1)
                );
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = standardParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = standardParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = standardParkingBoy.fetchCar(parkingTicket02);

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetchCar(unrecognizedParkingTicket));

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        standardParkingBoy.fetchCar(parkingTicket01);

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetchCar(parkingTicket01));

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.parkCar(firstCar));

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

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        //given
        ParkingTicket parkingTicket = standardParkingBoy.parkCar(car);

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = standardParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = standardParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = standardParkingBoy.fetchCar(parkingTicket02);

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);


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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        ParkingTicket parkingTicket02 = standardParkingBoy.parkCar(secondCar);

        //given
        Car returnedCar01 = standardParkingBoy.fetchCar(parkingTicket01);
        Car returnedCar02 = standardParkingBoy.fetchCar(parkingTicket02);


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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetchCar(unrecognizedParkingTicket));

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        ParkingTicket parkingTicket01 = standardParkingBoy.parkCar(firstCar);
        standardParkingBoy.fetchCar(parkingTicket01);

        //given
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetchCar(parkingTicket01));

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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car firstCar = new Car();

        //given
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.parkCar(firstCar));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}

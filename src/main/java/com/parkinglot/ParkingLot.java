package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkPositions.put(parkingTicket,car);
        return parkingTicket;
    }



    public Car fetchCar(ParkingTicket parkingTicket) {
        return parkPositions.get(parkingTicket);

    }
}

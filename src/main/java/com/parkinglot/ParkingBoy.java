package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private ParkingLot parkingLot;
    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();


    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;
        this.parkPositions.put(parkingTicket, car);
        return parkingTicket;

    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        this.car = this.parkPositions.get(parkingTicket);
        return this.car;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !this.parkPositions.containsKey(parkingTicket);
    }

}

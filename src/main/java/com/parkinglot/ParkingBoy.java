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

    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return null;

    }

}

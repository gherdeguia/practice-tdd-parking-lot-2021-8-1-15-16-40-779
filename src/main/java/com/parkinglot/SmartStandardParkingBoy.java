package com.parkinglot;

import java.util.*;

public class SmartStandardParkingBoy extends StandardParkingBoy {

    public SmartStandardParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findMoreSpaciousParkingLot().parkCar(car);
    }

    private ParkingLot findMoreSpaciousParkingLot(){
        return this.parkingLots.stream().min(Comparator.comparing(ParkingLot::returnCurrentCapacity)).get();
    }
}

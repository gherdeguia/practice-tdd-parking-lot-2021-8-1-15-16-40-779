package com.parkinglot;

import java.util.*;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findMoreSpaciousParkingLot().parkCar(car);
    }

    private ParkingLot findMoreSpaciousParkingLot(){
        return this.parkingLots.stream().max(Comparator.comparing(ParkingLot::returnCurrentCapacity)).get();
    }
}

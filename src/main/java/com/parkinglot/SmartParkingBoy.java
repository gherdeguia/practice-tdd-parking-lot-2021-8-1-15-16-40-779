package com.parkinglot;

import java.util.*;

public class SmartParkingBoy extends ParkingBoy{

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
        this.parkingLots = super.getParkingLots();
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findMoreSpaciousParkingLot().parkCar(car);
    }

    private ParkingLot findMoreSpaciousParkingLot(){
        return this.parkingLots.stream().min(Comparator.comparing(ParkingLot::returnCurrentCapacity)).get();
    }
}

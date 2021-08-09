package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartStandardParkingBoy extends ParkingBoy {

    public SuperSmartStandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findMoreSpaciousParkingLot().parkCar(car);
    }

    private ParkingLot findMoreSpaciousParkingLot() {
        return this.parkingLots.stream().max(Comparator.comparing(ParkingLot::returnCurrentCapacityRatio)).get();
    }
}

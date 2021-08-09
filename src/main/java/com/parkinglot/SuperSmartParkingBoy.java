package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findMoreSpaciousParkingLotRatio().parkCar(car);
    }

    private ParkingLot findMoreSpaciousParkingLotRatio() {
        return this.parkingLots.stream().min(Comparator.comparing(ParkingLot::returnCurrentCapacityRatio)).get();
    }
}

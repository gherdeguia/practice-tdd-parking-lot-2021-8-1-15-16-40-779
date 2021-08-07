package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = super.getParkingLots();
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return null;
    }
}

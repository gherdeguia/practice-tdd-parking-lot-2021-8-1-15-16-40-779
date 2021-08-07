package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private final int defaultCapacity = 10;
    private int maxCapacity;
    private int currentCapacity;

    public ParkingLot() {
        this.maxCapacity = defaultCapacity;
        this.currentCapacity = 0;
    }

    public ParkingLot(int maxCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        if (isFullParkingLotCapacity()) {
            throw new NoAvailablePositionException();
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;
        this.parkPositions.put(parkingTicket, car);
        this.currentCapacity++;
        return parkingTicket;

    }

    public Car fetchCar(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        this.car = this.parkPositions.get(parkingTicket);
        this.parkPositions.remove(parkingTicket);
        this.currentCapacity--;
        return this.car;
    }

    boolean isFullParkingLotCapacity() {
        return this.currentCapacity >= this.maxCapacity;
    }

    boolean hasAvailableParkingSlot(){
        return this.currentCapacity < this.maxCapacity;
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !this.parkPositions.containsKey(parkingTicket);
    }

    boolean findParkingTicketExists(ParkingTicket parkingTicket) {
        return this.parkPositions.containsKey(parkingTicket);
    }
}

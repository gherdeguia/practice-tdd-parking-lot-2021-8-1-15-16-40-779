package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private int maxCapacity = 10;
    private int currentCapacity = 0;

    public ParkingLot() {

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

    private boolean findParkingTicketExists(ParkingTicket parkingTicket) {
        return this.parkPositions.containsKey(parkingTicket);
    }

    public int getCurrentParkingLotCapacity(){
        return this.currentCapacity;
    }

    public int getMaxParkingCapacity(){
        return this.maxCapacity;
    }

    public boolean hasAvailableParkingSlot(ParkingLot parkingLot) {
        return this.currentCapacity < this.maxCapacity;
    }
}

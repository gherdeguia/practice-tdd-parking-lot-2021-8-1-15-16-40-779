package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private final static int defaultCapacity = 10;
    private int maxCapacity;

    public ParkingLot() {
        this.maxCapacity = defaultCapacity;
    }

    public ParkingLot(int maxCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.autoFillCapacity(currentCapacity);
    }

    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        if (isFullParkingLotCapacity()) {
            throw new NoAvailablePositionException();
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;
        this.parkPositions.put(parkingTicket, car);
        this.displayParkingCapacity();
        return parkingTicket;

    }

    public Car fetchCar(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException {
        if (isUnrecognizedTicket(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        this.car = this.parkPositions.get(parkingTicket);
        this.parkPositions.remove(parkingTicket);
        this.displayParkingCapacity();
        return this.car;
    }

    boolean isFullParkingLotCapacity() {
        return this.parkPositions.size() >= this.maxCapacity;
    }

    boolean hasAvailableParkingSlot(){
        return this.parkPositions.size() < this.maxCapacity;
    }

    int returnCurrentCapacity(){
        return this.maxCapacity - this.parkPositions.size();
    }

    double returnCurrentCapacityRatio(){
        return (double) this.parkPositions.size() / this.maxCapacity;
    }

    public void displayParkingCapacity(){
        System.out.println(String.format("Current Parking Capacity: %d / %d",this.returnCurrentCapacity(), this.maxCapacity));
    }

    private boolean isUnrecognizedTicket(ParkingTicket parkingTicket) {
        return !this.parkPositions.containsKey(parkingTicket);
    }

    boolean findParkingTicketExists(ParkingTicket parkingTicket) {
        return this.parkPositions.containsKey(parkingTicket);
    }

    public void autoFillCapacity(int currentCapacity){
        if(currentCapacity > this.parkPositions.size()){
            while(currentCapacity > this.parkPositions.size()){
                parkCar(new Car());
            }
        }
    }


}

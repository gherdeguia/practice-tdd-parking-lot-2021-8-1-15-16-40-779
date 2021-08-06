package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private int maxCapacity = 10;
    private int currentCapacity = 0;

    public ParkingLot(){

    }
    public ParkingLot(int maxCapacity,int currentCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;

        if(!isFullParkingLotCapacity()){
            this.parkPositions.put(parkingTicket,car);
            this.currentCapacity++;
            return parkingTicket;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if(findParkingTicketExists(parkingTicket)){
            this.car = this.parkPositions.get(parkingTicket);
            this.parkPositions.remove(parkingTicket);
            this.currentCapacity--;
            return this.car;
        }
        return null;
    }

    public boolean isFullParkingLotCapacity(){
        if(this.currentCapacity >= this.maxCapacity){
            return true;
        }
        return false;
    }

    public boolean findParkingTicketExists(ParkingTicket parkingTicket){
        if(this.parkPositions.containsKey(parkingTicket)){
            return true;
        }
        return false;
    }
}

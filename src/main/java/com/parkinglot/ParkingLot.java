package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private final int maxCapacity = 10;
    private int currentCapacity = 0;

    public ParkingLot(){

    }
    public ParkingLot(int maxCapacity){
        this.currentCapacity = maxCapacity;
    }

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;

        if(!fullParkingLotCapacity()){
            this.parkPositions.put(parkingTicket,car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if(findParkingTicketExists(parkingTicket)){
            this.car = this.parkPositions.get(parkingTicket);
            this.parkPositions.remove(parkingTicket);
            return this.car;
        }
        return null;
    }

    public ParkingTicket checkCorrectParkingTicket(ParkingTicket parkingTicket){
        if(this.parkPositions.containsKey(parkingTicket)){
            return parkingTicket;
        }
        return null;
    }

    public boolean fullParkingLotCapacity(){
        if(this.currentCapacity == this.maxCapacity){
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

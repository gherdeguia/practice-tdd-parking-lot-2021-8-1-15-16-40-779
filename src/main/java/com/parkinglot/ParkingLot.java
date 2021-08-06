package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();
    private final int maxCapacity = 10;
    private int currentCapacity = 10;

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;

        this.parkPositions.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {

        this.parkPositions.remove(parkingTicket);
        if(findParkingTicketExists(parkingTicket)){
            return this.parkPositions.get(parkingTicket);
        }
        return null;
    }

    public ParkingTicket checkCorrectParkingTicket(ParkingTicket parkingTicket){
        if(this.parkPositions.containsKey(parkingTicket)){
            return parkingTicket;
        }
        return null;
    }

    public boolean parkingLotCapacity(){
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

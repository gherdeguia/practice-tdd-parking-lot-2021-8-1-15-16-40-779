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

        parkPositions.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {

        parkPositions.remove(parkingTicket);
        if(findParkingTicketExists(parkingTicket)){
            return parkPositions.get(parkingTicket);
        }
        return null;
    }

    public ParkingTicket checkCorrectParkingTicket(ParkingTicket parkingTicket){
        if(parkPositions.containsKey(parkingTicket)){
            return parkingTicket;
        }
        return null;
    }

    public boolean findParkingTicketExists(ParkingTicket parkingTicket){
        if(parkPositions.containsKey(parkingTicket)){
            return true;
        }
        return false;
    }
}

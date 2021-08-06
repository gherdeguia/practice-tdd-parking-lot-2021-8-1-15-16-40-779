package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;

        parkPositions.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return parkPositions.get(parkingTicket);
    }

    public ParkingTicket checkCorrectParkingTicket(ParkingTicket parkingTicket){
        if(parkPositions.containsKey(parkingTicket)){
            return parkingTicket;
        }
        return null;
    }

    public boolean checkParkingTicketExists(ParkingTicket parkingTicket){
        if(parkPositions.containsKey(parkingTicket)){
            return true;
        }
        return false;
    }
}

package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Car car;
    private Map<ParkingTicket, Car> parkPosition = new HashMap<>();

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkPosition.put(parkingTicket,car);
        return parkingTicket;
    }



    public Car fetchCar(ParkingTicket parkingTicket) {
        return parkPosition.get(parkingTicket);

    }
}

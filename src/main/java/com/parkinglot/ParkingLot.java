package com.parkinglot;

import java.util.Map;

public class ParkingLot {

    public Car car;
    private Map<ParkingTicket, Car> parkPosition;

    public ParkingTicket parkCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        this.car = car;
        return new ParkingTicket(car);


    }



    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.car;
    }
}

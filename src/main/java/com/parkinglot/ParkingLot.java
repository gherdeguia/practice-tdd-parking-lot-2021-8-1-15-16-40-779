package com.parkinglot;

public class ParkingLot {

    public Car car;

    public ParkingTicket park(Car car) {
        this.car = car;
        return new ParkingTicket(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return this.car;
    }
}

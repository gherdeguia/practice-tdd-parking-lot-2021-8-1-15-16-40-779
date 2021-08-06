package com.parkinglot;

public class ParkingLot {

    public Car car;

    public ParkingTicket parkCar(Car car) {
        this.car = car;
        return new ParkingTicket(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.car;
    }
}

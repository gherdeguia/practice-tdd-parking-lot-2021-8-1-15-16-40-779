package com.parkinglot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;
    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();

    public SmartParkingBoy(List<ParkingLot> parkingLots){ this.parkingLots = parkingLots; }

    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findAvailableParkingLot().parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return findWhereParkingLotAndCar(parkingTicket).fetchCar(parkingTicket);
    }

    private ParkingLot findAvailableParkingLot(){
        return parkingLots.stream().filter(ParkingLot::hasAvailableParkingSlot).findFirst()
                .orElseThrow(NoAvailablePositionException::new);
    }
    private ParkingLot findMoreSpaceParkingLot(){
        return parkingLots.stream().max(Comparator.comparing(ParkingLot::returnCurrentCapacity))
                .orElseThrow(NoAvailablePositionException::new);
    }

    private ParkingLot findWhereParkingLotAndCar(ParkingTicket parkingTicket){
        return parkingLots.stream().filter(parkingLot -> parkingLot.findParkingTicketExists(parkingTicket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
    }
}

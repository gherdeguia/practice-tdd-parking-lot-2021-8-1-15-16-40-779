package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy {
    protected List<ParkingLot> parkingLots;
    public Car car;
    private final Map<ParkingTicket, Car> parkPositions = new HashMap<>();

    public StandardParkingBoy(List<ParkingLot> parkingLots){ this.parkingLots = parkingLots; }

    public ParkingTicket parkCar(Car car) throws NoAvailablePositionException {
        return findAvailableParkingLot().parkCar(car);
    }

    protected Car fetchCar(ParkingTicket parkingTicket) {
        return findWhereParkingLotAndCar(parkingTicket).fetchCar(parkingTicket);
    }

    public ParkingLot findAvailableParkingLot(){
        return parkingLots.stream().filter(ParkingLot::hasAvailableParkingSlot).findFirst()
                .orElseThrow(NoAvailablePositionException::new);
    }

    public ParkingLot findWhereParkingLotAndCar(ParkingTicket parkingTicket){
        return parkingLots.stream().filter(parkingLot -> parkingLot.findParkingTicketExists(parkingTicket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
    }

}

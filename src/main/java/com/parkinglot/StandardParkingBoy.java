package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy extends ParkingBoy{

    public StandardParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

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

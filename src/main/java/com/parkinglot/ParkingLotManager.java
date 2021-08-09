package com.parkinglot;

import java.util.List;

public class ParkingLotManager extends ParkingBoy {

    ManagementList managementList;
    StandardParkingBoy standardParkingBoys;
    SmartParkingBoy smartParkingBoys;

    public ParkingLotManager(List<ParkingLot> parkingLots, ManagementList managementList) {
        super(parkingLots);
        this.managementList = managementList;
        this.standardParkingBoys = new StandardParkingBoy(parkingLots);
        this.smartParkingBoys = new SmartParkingBoy(parkingLots);
    }

    public List<ParkingBoy> getParkingBoysList() {
        return this.managementList.getManagementList();
    }

    public ParkingTicket makeParkingBoyPark(Car car){
        return super.parkCar(car);
    }

    public ParkingTicket makeSmartParkingBoyPark(Car car){
        return smartParkingBoys.parkCar(car);
    }

    public Car makeParkingBoyFetchCar(ParkingTicket parkingTicket) {
        return super.fetchCar(parkingTicket);
    }

    public Car makeSmartParkingBoyFetchCar(ParkingTicket parkingTicket) { return smartParkingBoys.fetchCar(parkingTicket); }

}

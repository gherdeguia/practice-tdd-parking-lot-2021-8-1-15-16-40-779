package com.parkinglot;

import java.util.List;

public class StandardParkingLotManager extends StandardParkingBoy {

    ManagementList managementList;
    StandardParkingBoy standardParkingBoys;
    SmartStandardParkingBoy smartParkingBoy;

    public StandardParkingLotManager(List<ParkingLot> parkingLots, ManagementList managementList) {
        super(parkingLots);
        this.managementList = managementList;
        this.standardParkingBoys = new StandardParkingBoy(parkingLots);
        this.smartParkingBoy = new SmartStandardParkingBoy(parkingLots);
    }

    public List<StandardParkingBoy> getParkingBoysList() {
        return this.managementList.getManagementList();
    }

    public ParkingTicket makeParkingBoyPark(Car car){
//        System.out.println("Parking Boy successfully parked");
        return super.parkCar(car);
    }

    public ParkingTicket makeSmartParkingBoyPark(Car car){
//        System.out.println("Smart Parking Boy successfully parked");
        return smartParkingBoy.parkCar(car);
    }

    public Car makeParkingBoyFetchCar(ParkingTicket parkingTicket) {
        return super.fetchCar(parkingTicket);
    }

    public Car makeSmartParkingBoyFetchCar(ParkingTicket parkingTicket) { return smartParkingBoy.fetchCar(parkingTicket); }

}

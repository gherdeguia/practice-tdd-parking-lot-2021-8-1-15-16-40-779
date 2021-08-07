package com.parkinglot;

import java.util.List;

public class ParkingLotManager extends ParkingBoy{

    ManagementList managementList;
    ParkingBoy parkingBoys;
    SmartParkingBoy smartParkingBoy;

    public ParkingLotManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingLotManager(List<ParkingLot> parkingLots, ManagementList managementList) {
        super(parkingLots);
        this.managementList = managementList;
        this.parkingBoys = new ParkingBoy(parkingLots);
        this.smartParkingBoy = new SmartParkingBoy(parkingLots);
    }

    public ManagementList getParkingBoysList() {
        return this.managementList.;
    }

    public ParkingTicket makeParkingBoyPark(Car car){
        System.out.println("Parking Boy successfully parked");
        return super.parkCar(car);
    }

    public ParkingTicket makeSmartParkingBoyPark(Car car){
        System.out.println("Smart Parking Boy successfully parked");
        return smartParkingBoy.parkCar(car);
    }
}

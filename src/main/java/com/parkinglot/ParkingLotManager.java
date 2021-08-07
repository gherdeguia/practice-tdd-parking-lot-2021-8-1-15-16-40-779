package com.parkinglot;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ParkingTicket parkCar(Car car){
//        System.out.println("Parking Lot Manager successfully parked");
        return super.parkCar(car);
    }

    public List<ParkingBoy> getParkingBoysList() {
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

    public ParkingLot findWhereParkingLotParked(ParkingTicket parkingTicket){
        return super.findWhereParkingLotAndCar(parkingTicket);
    }
}

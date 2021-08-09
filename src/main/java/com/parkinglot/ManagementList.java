package com.parkinglot;


import java.util.List;
import java.util.stream.Collectors;

public class ManagementList {

    private List<ParkingBoy> managementList;

    public ManagementList(List<ParkingBoy> standardParkingBoys) {
        this.managementList = standardParkingBoys;
    }

    public void addParkingBoy(SmartParkingBoy standardParkingBoy) {

    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList.stream().collect(Collectors.toList());
    }
}

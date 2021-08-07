package com.parkinglot;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManagementList {

    private List<ParkingBoy> managementList;

    public ManagementList(List<ParkingBoy> parkingBoys) {
        this.managementList = parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {

    }

    public List<ParkingBoy> getManagementList() {
        return this.managementList.stream().collect(Collectors.toList());
    }
}

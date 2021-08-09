package com.parkinglot;


import java.util.List;
import java.util.stream.Collectors;

public class ManagementList {

    private List<StandardParkingBoy> managementList;

    public ManagementList(List<StandardParkingBoy> standardParkingBoys) {
        this.managementList = standardParkingBoys;
    }

    public void addParkingBoy(StandardParkingBoy standardParkingBoy) {

    }

    public List<StandardParkingBoy> getManagementList() {
        return this.managementList.stream().collect(Collectors.toList());
    }
}

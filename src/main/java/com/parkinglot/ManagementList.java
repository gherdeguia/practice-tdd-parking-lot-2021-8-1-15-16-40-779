package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ManagementList {

//    ManagementList managementList;

    List<ParkingBoy> managementList;

    public ManagementList(){
        managementList = new ArrayList<>();
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

}

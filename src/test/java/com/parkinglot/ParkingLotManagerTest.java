package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotManagerTest {

    @Test
    void should_return_parking_boy_in_list_when_parking_manager_given_new_parking_boy_and_parking_boy_list() {
        //when
        List<ParkingLot> parkingLotsA =
                Arrays.asList(
                        new ParkingLot(15,12),
                        new ParkingLot(20,15),
                        new ParkingLot(15,1)
                );


        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotsA);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotsA);

        List<ParkingBoy> parkingBoys =
                Arrays.asList(
                        parkingBoy1,
                        parkingBoy2
                );

        SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLotsA);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        //given
        ManagementList managementList = new ManagementList(parkingBoys);
        managementList.addParkingBoy(smartParkingBoy1);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotsA, managementList);
        List<ParkingBoy> managementParkingBoyList = parkingLotManager.getParkingBoysList();

        ParkingTicket parkingTicket1 = parkingLotManager.parkCar(firstCar);
        ParkingTicket parkingTicket2 = parkingLotManager.makeParkingBoyPark(secondCar);
        ParkingTicket parkingTicket3 = parkingLotManager.makeSmartParkingBoyPark(thirdCar);

        //then
        System.out.print(managementParkingBoyList);
        assertNotNull(managementParkingBoyList);
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);
        assertNotNull(parkingTicket3);
    }
}

package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        StandardParkingBoy standardParkingBoy1 = new StandardParkingBoy(parkingLotsA);
        StandardParkingBoy standardParkingBoy2 = new StandardParkingBoy(parkingLotsA);
        SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLotsA);

        List<ParkingBoy> standardParkingBoys =
                Arrays.asList(
                        standardParkingBoy1,
                        standardParkingBoy2,
                        smartParkingBoy1
                );
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        //given
        ManagementList managementList = new ManagementList(standardParkingBoys);
        managementList.addParkingBoy(smartParkingBoy1);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotsA, managementList);
        List<ParkingBoy> managementStandardParkingBoyList = parkingLotManager.getParkingBoysList();

        ParkingTicket parkingTicket1 = parkingLotManager.parkCar(firstCar);
        ParkingTicket parkingTicket2 = parkingLotManager.makeParkingBoyPark(secondCar);
        ParkingTicket parkingTicket3 = parkingLotManager.makeSmartParkingBoyPark(thirdCar);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLotManager.makeParkingBoyFetchCar(unrecognizedParkingTicket));
        Car returnedCar01 = parkingLotManager.makeSmartParkingBoyFetchCar(parkingTicket2);

        //then
        System.out.print(managementStandardParkingBoyList);
        assertNotNull(managementStandardParkingBoyList);
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);
        assertNotNull(parkingTicket3);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}

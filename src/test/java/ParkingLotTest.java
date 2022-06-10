import CustomException.SpaceNotAvailable;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void shouldParkCarWhenSpaceIsAvailableInParkingLot() throws CustomException.VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(100,new HashSet<>());
        com.tw.Vehicle.Vehicle car=new com.tw.Vehicle.Car();
        int slotsFilled=parkingLot.parkMatrix.size();
        parkingLot.parkVehicle(car);

        assertEquals(slotsFilled+1,parkingLot.parkMatrix.size());
    }
    @Test
    void shouldParkCarWhenSpaceIsAvailable() throws CustomException.VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(1,new HashSet<>());
        com.tw.Vehicle.Vehicle car=new com.tw.Vehicle.Car();
        parkingLot.parkVehicle(car);
        com.tw.Vehicle.Vehicle car1=new com.tw.Vehicle.Car();

        Throwable exception=assertThrows(SpaceNotAvailable.class, ()->{
            parkingLot.parkVehicle(car1);
        });
    }
    @Test
    void shouldParkCarrNotInParkingLot() throws CustomException.VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(1,new HashSet<>());
        com.tw.Vehicle.Vehicle car=new com.tw.Vehicle.Car();
        parkingLot.parkVehicle(car);

        Throwable exception=assertThrows(CustomException.VehicleAlreadyExists.class, ()->{
            parkingLot.parkVehicle(car);
        });
    }
}

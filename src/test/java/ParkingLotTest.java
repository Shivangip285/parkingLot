import CustomException.SpaceNotAvailable;
import CustomException.VehicleAlreadyExists;
import com.tw.Vehicle.Car;
import com.tw.Vehicle.Parkable;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {
    @Test
    void shouldParkCarWhenSpaceIsAvailableInParkingLot() throws VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(100,new HashSet<>());
        Parkable car=new Car();
        int slotsFilled=parkingLot.parkMatrix.size();
        parkingLot.parkVehicle(car);

        assertEquals(slotsFilled+1,parkingLot.parkMatrix.size());
    }
    @Test
    void shouldParkCarWhenSpaceIsAvailable() throws VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(1,new HashSet<>());
        Parkable car=new Car();
        parkingLot.parkVehicle(car);
        Parkable car1=new Car();

        Throwable exception=assertThrows(SpaceNotAvailable.class, ()->{
            parkingLot.parkVehicle(car1);
        });
    }
    @Test
    void shouldParkCarrNotInParkingLot() throws VehicleAlreadyExists, SpaceNotAvailable {
        ParkingLot parkingLot=new ParkingLot(1,new HashSet<>());
        Parkable car=new Car();
        parkingLot.parkVehicle(car);

        Throwable exception=assertThrows(CustomException.VehicleAlreadyExists.class, ()->{
            parkingLot.parkVehicle(car);
        });
    }
}

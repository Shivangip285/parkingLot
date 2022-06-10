import CustomException.SpaceNotAvailable;
import CustomException.VehicleAlreadyExists;
import com.tw.Vehicle.Parkable;

import java.util.HashSet;
public class ParkingLot {
    private int capacity;

    public HashSet<Object> parkMatrix;

    public ParkingLot(int capacity, HashSet<Object> parkMatrix ) {
        this.capacity = capacity;
        this.parkMatrix=parkMatrix;
    }

    public void parkVehicle(Parkable car) throws VehicleAlreadyExists, SpaceNotAvailable {

        if(parkMatrix.contains(car)) {
            throw new VehicleAlreadyExists("vehicle is already parked");
        }
        if (parkMatrix.size()==capacity) {
            throw new SpaceNotAvailable("space is not available");
        }
        parkMatrix.add(car);
    }

}


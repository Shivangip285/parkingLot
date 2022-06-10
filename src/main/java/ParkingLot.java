import CustomException.SpaceNotAvailable;

import java.util.HashSet;
public class ParkingLot {
    private int capacity;

    public HashSet<Object> parkMatrix;

    public ParkingLot(int capacity, HashSet<Object> parkMatrix ) {
        this.capacity = capacity;
        this.parkMatrix=parkMatrix;
    }

    public void parkVehicle(Object car) throws CustomException.VehicleAlreadyExists, SpaceNotAvailable {

        if(parkMatrix.contains(car)) {
            throw new CustomException.VehicleAlreadyExists("vehicle is already parked");
        }
        if (parkMatrix.size()==capacity) {
            throw new SpaceNotAvailable("space is not available");
        }
        parkMatrix.add(car);
    }

}


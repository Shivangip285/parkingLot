package CustomException;

public class VehicleAlreadyExists extends Exception{
    public VehicleAlreadyExists(String s) {
        super(s);
    }
}

package CustomException;

public class SpaceNotAvailableException extends Exception {
    public SpaceNotAvailableException(String s) {
        super(s);
    }
}
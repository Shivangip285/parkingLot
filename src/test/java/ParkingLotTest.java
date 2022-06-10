import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    void shouldReturnIfCarIsParked()
    {
        ParkingLot parkingLot=new ParkingLot();

        boolean carParked=parkingLot.Parked();

        assertTrue(carParked);
    }
}

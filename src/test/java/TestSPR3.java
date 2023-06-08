import fr.epita.datamodel.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestSPR3 {

    @Inject
    Passenger passenger;

    @Test
    public void testPassenger() {
        // Given: id, and the Passenger instance is injected
        String id = "sachiththa-bandaranayake";

        // When: Accessing the passenger's name
        String passengerName = passenger.getName();

        // Then: Assert that the passenger name is {id}
        Assertions.assertEquals(id, passengerName);

    }
}

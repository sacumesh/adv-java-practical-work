import fr.epita.datamodel.Passenger;
import fr.epita.services.PassengerCSVDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Dictionary;
import java.util.List;

public class TestJUN2 {

    private PassengerCSVDAO csvdao;

    @BeforeEach
    public  void beforeds(){
        System.out.println("hello");
        this.csvdao = new PassengerCSVDAO();
    }

    @Test
    public void testDeserialization () {
        System.out.println("dfsdfds");
        // Given
        File file = new File("./src/test/resources/data.csv");
        this.csvdao.setFile(file);
        // data corresponding 12th entry in the data file
        String name = "Astor, Colonel John Jacob";
        String pClass =  "1st";
        Double age = 47d;
        String sex = "male";
        Boolean survived = false;

        // When
        List<Passenger> passengers = this.csvdao.readAll();

        // Then
        // Display the passengers
        System.out.println(passengers);

        // 1st line is omitted in the file, thus the index corresponding to 12th entry is 10.
        Passenger passenger = passengers.get(10);

        // Some lines are not parsed because of missing data therefore it's impossible to test for expected size
        Assertions.assertTrue(passengers.size() >= 100, "At least 13 entries are required");

        Assertions.assertEquals(name, passenger.getName(), "Name does not match");
        Assertions.assertEquals(pClass, passenger.getPassengerClass(), "Passenger class does not match");
        Assertions.assertEquals(age, passenger.getAge(), "Age does not match");
        Assertions.assertEquals(sex, passenger.getSex(), "Sex does not match");
        Assertions.assertEquals(survived, passenger.getSurvived(), "Survival status does not match");
    }

}

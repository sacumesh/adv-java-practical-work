import fr.epita.datamodel.Passenger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringApplicationContext {

    private String id = "sachiththa-bandaranayake";

    @Bean(name = "myFirstBean")
    public String myFirstBean() {
        return "Hello from Spring, " + id;
    }

    @Bean
    public Passenger passenger() {
        return new Passenger(id, "1st", 27d, "male", true);
    }

    @Bean
    public DataSource mainDatasource(){
        return new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user","user");
    }



}

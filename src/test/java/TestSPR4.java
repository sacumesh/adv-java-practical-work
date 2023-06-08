import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestSPR4 {

@Inject
private DataSource dataSource;

@Test
public void testDatabaseConnection()  {
    // Given: dataSource is injected

    // When: Trying to establish a database connection
    try (Connection connection = dataSource.getConnection()) {
        // Then: Assert that the connection is not null
        Assertions.assertNotNull(connection);

    } catch (SQLException e) {
        // Failed to establish a database connection
        Assertions.fail("Failed to establish a database connection: " + e.getMessage());
    }

}


}

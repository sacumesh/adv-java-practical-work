import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestSPR2 {

    @Inject
    @Named("myFirstBean")
    private String myFirstBean;

    @Test
    public void testMyFirstBean(){
        System.out.println(myFirstBean);
    }

}

package by.itacademy;

import by.itacademy.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@Transactional
public class BaseTest {

    @Test
    public void nothing() {

    }
}

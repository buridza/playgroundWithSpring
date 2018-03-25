package by.itacademy;

import by.itacademy.entity.account.user.User;
import by.itacademy.impl.UserServiceImpl;
import by.itacademy.interfaces.UserService;
import config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@Transactional
public class TestAsp {
    @Autowired
    UserService userService;


    @Test
    public void test() {
        User tuio = userService.getUserByLogin("Tuio");
        System.out.println(tuio);
    }
}

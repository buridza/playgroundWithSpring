package by.itacademy;

import by.itacademy.entity.account.user.User;
import by.itacademy.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserTest extends BaseTest{
    @Autowired
    UserRepository userRepository;
    @Test
    public void getUser() {
        Iterable<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }
}

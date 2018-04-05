package by.itacademy;

import by.itacademy.entity.account.Address;
import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.account.user.Role;
import by.itacademy.entity.account.user.User;
import by.itacademy.repository.GameRepository;
import by.itacademy.repository.UserRepository;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;


public class UserTest extends BaseTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GameRepository gameRepository;
    @Test
    public void optimistickLockExText() {
        User one = userRepository.findOne(239L);
        one.setName("verTest1");
        userRepository.save(one);
        one.setName("verTest2");
        userRepository.save(one);


    }

    @Test
    public void getUser() {
        Iterable<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void addGameToUser() {
        User one = userRepository.findOne(39L);
        one.getGames().add(gameRepository.findOne(1L));
        User save = userRepository.save(one);
        System.out.println(save);
    }

    public String email(int rand) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < rand; i++) {
            str += String.copyValueOf(Character.toChars(65 + new Random().nextInt(47)));
        }
        return str;
    }


    /* @Test

     public void saveCount() {
         for (int i = 0; i < 100; i++) {
             saveUser();
         }
     }*/
    @Test

    public void saveUser() {

        User user = new User();
        Random random = new Random();
        user.setDateOfBirthday(LocalDate.of(random.nextInt(20) + 1990,
                Month.of(random.nextInt(11) + 1),
                (random.nextInt(30) + 1)));
        /*user.setDateOfBirthday(LocalDate.parse((random.nextInt(20)+1990)
                +"-"+random.nextInt(12)
                +"-"+(10+random.nextInt(10))));*/
        user.setLanguage(Language.values()[random.nextInt(3)]);
        user.setAddress(new Address(
                "Minsk", "Kolasa, " + random.nextInt(100), random.nextInt(100), random.nextInt(1000)
        ));
        user.setEmail(email(random.nextInt(20)) + "@gmail.com");
        user.setLogin("Vasya" + email(random.nextInt(20)));
        user.setName(email(random.nextInt(20)));
        user.setPassword(random.nextInt() + email(random.nextInt(10)));
        user.setRole(Role.MODERATOR);
        userRepository.save(user);

    }

    @Test
    public void updateUser() {

        userRepository.findUsersByRole(Role.USER).forEach(user -> System.out.println(user));
        List<User> usersByRole = userRepository.findUsersByRole(Role.USER);
        usersByRole.forEach(user -> user.setLanguage(Language.values()[new Random().nextInt(4)]));
        userRepository.save(usersByRole);
        System.out.println("___________________");
        userRepository.findUsersByRole(Role.USER).forEach(user -> System.out.println(user));

    }

    @Test
    public void yetSaveUserTest() {
        User entity = new User();
        entity.setLanguage(Language.ENGLISH);
        entity.setRole(Role.USER);
        entity.setDateOfBirthday(LocalDate.now());
        entity.setPassword("12345");
        entity.setName("Alex");
        entity.setLogin("TheBest");
        entity.setEmail("THeBest@gmail.com");
        entity.setAddress(new Address("Belarus", "Minsk", 10, 10));
        userRepository.save(entity);
    }
}

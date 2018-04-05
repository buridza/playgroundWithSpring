package by.itacademy.interfaces;

import by.itacademy.entity.account.user.User;
import by.itacademy.exception.NotUniqueException;
import by.itacademy.impl.AccountUserDTO;

import by.itacademy.impl.Filter;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public interface UserService extends UserDetailsService {
    User registerNewUser(AccountUserDTO user) throws NotUniqueException;
    User saveUserByUserName(String name, User user);
    User getUserByLogin(String name);
    User addGameForUser(String login, Serializable id);
    User updateUserById(User user/*, Long id*/);
    Page<List<Object>> entities(Filter filter);
}

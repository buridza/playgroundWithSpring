package by.itacademy;

import by.itacademy.entity.account.user.User;
import by.itacademy.exception.NotUniqueException;
import by.itacademy.impl.AccountUser;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public interface UserService extends UserDetailsService {
    User registerNewUser(AccountUser user) throws NotUniqueException;
    User saveUserByUserName(String name, User user);
    User getUserByLogin(String name);
    User addGameForUser(String login, Serializable id);
    User updateUserById(User user, Long id);
}

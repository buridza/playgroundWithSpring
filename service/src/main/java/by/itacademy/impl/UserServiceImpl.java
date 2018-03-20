package by.itacademy.impl;

import by.itacademy.UserService;
import by.itacademy.exception.NotUniqueException;
import by.itacademy.repository.GameRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        by.itacademy.entity.account.user.User user = userRepository.findUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }

        return new User(user.getLogin(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
    }

    @Override
    public by.itacademy.entity.account.user.User registerNewUser(AccountUser user) throws NotUniqueException {

        by.itacademy.entity.account.user.User entityUser = new by.itacademy.entity.account.user.User();
        entityUser.setLogin(user.getLogin());
        entityUser.setName(user.getName());
        entityUser.setPassword(user.getPassword());
        entityUser.setAddress(user.getAddress());
        entityUser.setEmail(user.getEmail());
        entityUser.setDateOfBirthday(user.getDateOfBirthday());
        entityUser.setRole(user.getRole());
        entityUser.setLanguage(user.getLanguage());
        try {
            return userRepository.save(entityUser);
        } catch (ConstraintViolationException e) {
            throw new NotUniqueException(e.getMessage(), e);
        }
    }

    @Override
    public by.itacademy.entity.account.user.User saveUserByUserName(String login, by.itacademy.entity.account.user.User user) {
        return userRepository.save(userRepository.findUserByLogin(login));
    }

    @Override
    public by.itacademy.entity.account.user.User getUserByLogin(String name) {
        return userRepository.findUserByLogin(name);
    }

    @Override
    public by.itacademy.entity.account.user.User addGameForUser(String login, Serializable id) {
        by.itacademy.entity.account.user.User userByLogin = userRepository.findUserByLogin(login);
        userByLogin.getGames().add(gameRepository.findOne((long)id));
        return userRepository.save(userByLogin);
    }
}

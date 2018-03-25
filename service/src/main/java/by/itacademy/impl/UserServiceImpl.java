package by.itacademy.impl;

import by.itacademy.interfaces.UserService;
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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        User user1 = new User(user.getLogin(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
        return user1;
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
        userByLogin.getGames().add(gameRepository.findOne((long) id));
        return userRepository.save(userByLogin);
    }

    @Override
    public by.itacademy.entity.account.user.User updateUserById(by.itacademy.entity.account.user.User user, Long id) {


        Class<? extends by.itacademy.entity.account.user.User> userChanged = user.getClass();
        Field[] declaredFields = userChanged.getDeclaredFields();
        List<Field> collect = Arrays.stream(declaredFields).peek(field -> field.setAccessible(true)).collect(Collectors.toList());
        List<Field> notNullFields = collect.stream().filter(Objects::nonNull).collect(Collectors.toList());

        by.itacademy.entity.account.user.User one = userRepository.findOne(id);
        List<Method> get = Arrays.stream(userChanged.getMethods()).filter(method -> method.getName().contains("get")).collect(Collectors.toList());
        List<Method> collect1 = get.stream().filter(method -> {
                    Object invoke = null;
                    try {
                        invoke = method.invoke(user);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    if(invoke == null) {
                        return false;
                    } else return true;
                }
        ).collect(Collectors.toList());

        System.out.println(one);
        Class<? extends by.itacademy.entity.account.user.User> oneClass = one.getClass();
        Method[] oneClassMethods = oneClass.getMethods();
        collect1.forEach(methodGet ->
                Arrays.stream(oneClassMethods).filter(method ->
                        method.getName()
                        .contains(methodGet.getName()
                        .subSequence(3,methodGet.getName().length())))
                .peek(filterMethod-> {
                    try {
                        filterMethod.invoke(one, methodGet.invoke(user));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                })
        );
        System.out.println(user.getName());
        System.out.println(user);
        one.setName(user.getName());
        System.out.println(one);
        return userRepository.save(one);
    }
}

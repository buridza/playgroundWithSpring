package by.itacademy.repository;

import by.itacademy.entity.account.user.Role;
import by.itacademy.entity.account.user.User;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends  JpaRepository<User, Long>{
    //List<User> findAll();
    List<User> findUsersByRole(Role role);

    User findByName(String username);
    User findUserByLogin(String login);
}

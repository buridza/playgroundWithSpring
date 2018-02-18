package by.itacademy.repository;

import by.itacademy.entity.account.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    //List<User> findAll();

}

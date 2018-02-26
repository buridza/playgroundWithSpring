package by.itacademy.repository;

import by.itacademy.entity.account.user.Friends;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FriendsRepository extends PagingAndSortingRepository<Friends, Long> {
}

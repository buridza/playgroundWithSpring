package by.itacademy.repository;

import by.itacademy.entity.account.user.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

}

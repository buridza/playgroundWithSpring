package by.itacademy.repository;

import by.itacademy.entity.account.user.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

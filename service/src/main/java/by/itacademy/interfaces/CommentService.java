package by.itacademy.interfaces;

import by.itacademy.entity.account.user.Comment;
import by.itacademy.impl.Filter;
import org.springframework.data.domain.Page;

public interface CommentService {
    Page<Comment> allComments(Filter filter);
    void delete(Comment comment);
    Comment editComment(Comment comment);
}

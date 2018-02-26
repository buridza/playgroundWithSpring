package by.itacademy;

import by.itacademy.entity.account.user.Comment;
import by.itacademy.repository.CommentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class CommentTest extends BaseTest{

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void findAllCommentTest() {
        Page<Comment> page;
        for (int i = 0; i < commentRepository.count(); i++) {
            commentRepository.findAll(new PageRequest(i, 5))
                    .forEach(a-> System.out.println(a.getMessage()));
        }
    }
}

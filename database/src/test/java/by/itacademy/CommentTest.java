package by.itacademy;

import by.itacademy.entity.account.user.Comment;
import by.itacademy.repository.CommentRepository;
import by.itacademy.repository.GameRepository;
import by.itacademy.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Random;

public class CommentTest extends BaseTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @Test
    public void findAllCommentTest() {
        for (int i = 0; i < commentRepository.count(); i++) {
            commentRepository.findAll(new PageRequest(i, 5))
                    .forEach(a -> System.out.println(a.getMessage()));
        }
    }

    @Test
    public void saveCommentCount() {
        for (int i = 0; i < 100; i++) {
            createComment();
        }
    }

    @Test
    public void createComment() {
        Comment comment = new Comment();
        Random random = new Random();
        comment.setMessage(random.nextBoolean() ? "good" : "bad" + " game");
        comment.setRating(random.nextInt(5));
        comment.setUser(userRepository.findOne((long) random.nextInt(20)));
        comment.setGame(gameRepository.findOne((long) random.nextInt(36)));
        commentRepository.save(comment);
    }

    @Test
    public void getTest() {
        List<Comment> all = commentRepository.findAll();
        all.forEach(System.out::println);
        all.forEach(comment -> System.out.println(comment.getMessage()));
        all.forEach(comment -> System.out.println(comment.getGame()));
        all.forEach(comment -> System.out.println(comment.getRating()));
        all.forEach(comment -> System.out.println(comment.getUser()));

    }

    @Test
    public void addRandomUserForComments() {

        commentRepository.findAll().forEach(comment -> {
                    comment.setUser(userRepository.findAll().get(new Random().nextInt(32)));
                    commentRepository.save(comment); }
        );


    }


}

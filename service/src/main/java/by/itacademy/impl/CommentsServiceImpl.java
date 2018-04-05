package by.itacademy.impl;

import by.itacademy.entity.account.user.Comment;
import by.itacademy.interfaces.CommentService;
import by.itacademy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    @Autowired
    public CommentsServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<Comment> allComments(Filter filter) {
        return commentRepository.findAll(new PageRequest(filter.getNextPage(), filter.getNumberOfRows()));
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment editComment(Comment comment) {
        Comment one = commentRepository.findOne(comment.getId());
        one.setMessage(comment.getMessage());
        return commentRepository.save(one);
    }
}

package by.itacademy.controller;

import by.itacademy.entity.account.user.Comment;
import by.itacademy.entity.account.user.User;
import by.itacademy.impl.Filter;
import by.itacademy.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ModelAttribute("comments")
    public Page<Comment> commentPage(Filter filter) {

        Page<Comment> page = commentService.allComments(filter);
        page.forEach(comment -> System.out.println(comment.getId()));
        return page;
    }

    @ModelAttribute
    public Filter filter() {
        return new Filter();
    }
        @ModelAttribute("newComment")
        public Comment newComment() {
            return new Comment();
        }

    @GetMapping("CommentPage")
    public String showCommentPage(Filter filter) {
        return "auth/CommentPage";
    }

    @GetMapping("addNewComment")
    public String addNewComment(Filter filter, Model model, @SessionAttribute User user) {
        return "auth/CommentPage";
    }

    @PostMapping("deleteComment")
    public String deleteComment(Comment comment, @RequestParam Long id) {
        comment.setId(id);
        commentService.delete(comment);
        return "redirect:CommentPage";
    }

    @GetMapping("editComment")
    public String showEditComment(Model model, @RequestParam Long id) {
        model.addAttribute("commentId", id);
        return "auth/EditComment";
    }

    @PostMapping("editComment")
    public String editComment(Comment newComment, @RequestParam Long id, Filter filter) {
        newComment.setId(id);
        commentService.editComment(newComment);
        return "auth/CommentPage";
    }
}

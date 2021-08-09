package com.api.api_e_commerce_project_gradute.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

  @Autowired
  CommentService commentService;

  @CrossOrigin
  @GetMapping("comments")
  public List<Comment> getAllComments() {
    return commentService.getAllComments();
  }

  @CrossOrigin
  @GetMapping("comments/{idComment}")
  public Optional<Comment> getCommentById(@PathVariable Long idComment) {
    return commentService.getCommentById(idComment);
  }

  @CrossOrigin
  @PostMapping("comments")
  public Comment addComment(@RequestBody Comment comment) {
    return commentService.addComment(comment);
  }

  @CrossOrigin
  @PutMapping("comments")
  public Comment updateComment(@RequestBody Comment comment) {
    return commentService.addComment(comment);
  }

}

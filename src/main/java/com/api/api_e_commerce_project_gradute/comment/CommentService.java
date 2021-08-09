package com.api.api_e_commerce_project_gradute.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

  @Autowired
  CommentRepository commentRepository;

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  public Optional<Comment> getCommentById(Long idComment) {
    return commentRepository.findById(idComment);
  }

  public Comment addComment(Comment comment) {
    return commentRepository.save(comment);
  }

}

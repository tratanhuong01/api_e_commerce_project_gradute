package com.api.api_e_commerce_project_gradute.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

  @Autowired
  CommentRepository commentRepository;

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  public Comment getCommentById(Long idComment) {
    return commentRepository.getById(idComment);
  }

  public Comment addComment(Comment comment) {
    return commentRepository.save(comment);
  }

}

package com.api.api_e_commerce_project_gradute.comment;

import com.api.api_e_commerce_project_gradute.DTO.comment.CommentLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

  @Autowired
  CommentRepository commentRepository;

  public int getAllComments(Long idNews) {
    return commentRepository.getAllComment(idNews);
  }

  public List<CommentLevel> getAllCommentLimit(Long idNews,int offset,int limit) {
    List<Comment> commentList = commentRepository.getAllCommentLimit(idNews, offset, limit);
    List<CommentLevel> commentLevelList = new ArrayList<>();
    for (Comment comment: commentList) {
      CommentLevel commentLevel = new CommentLevel();
      commentLevel.setComment(comment);
      commentLevel.setCommentList(commentRepository.getListCommentLevelTwoByIdNews(comment.getId(),0,2));
      commentLevelList.add(commentLevel);
    }
    return commentLevelList;
  }

  public Optional<Comment> getCommentById(Long idComment) {
    return commentRepository.findById(idComment);
  }

  public Comment addComment(Comment comment) {
    comment.setTimeCreated((new Timestamp(new Date().getTime())));
    return commentRepository.save(comment);
  }

}

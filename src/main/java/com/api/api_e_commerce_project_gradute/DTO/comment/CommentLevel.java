package com.api.api_e_commerce_project_gradute.DTO.comment;

import com.api.api_e_commerce_project_gradute.comment.Comment;

import java.util.List;

public class CommentLevel {
  Comment comment;
  List<Comment> commentList;

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }
}

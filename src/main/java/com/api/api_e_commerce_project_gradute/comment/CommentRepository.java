package com.api.api_e_commerce_project_gradute.comment;

import com.api.api_e_commerce_project_gradute.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

  @Query(value = "SELECT * FROM comment WHERE id_news = ?1 AND level = 1 LIMIT 0,5 ",nativeQuery = true)
  List<Comment> getListCommentLevelOneByIdNews(Long idNews);

  @Query(value = "SELECT * FROM comment WHERE reply = ?1 AND level = 2 LIMIT 0,5 ",nativeQuery = true)
  List<Comment> getListCommentLevelTwoByIdNews(Long idNews);
}

package com.api.api_e_commerce_project_gradute.comment;

import com.api.api_e_commerce_project_gradute.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

  @Query(value = "SELECT COUNT(*) FROM comment WHERE id_news = ?1 AND level = 1 ",nativeQuery = true)
  int getAllComment(Long idNews);

  @Query(value = "SELECT * FROM comment WHERE id_news = ?1 AND level = 1 ORDER BY time_created DESC " +
      "LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Comment> getAllCommentLimit(Long idNews,int offset,int limit);

  @Query(value = "SELECT * FROM comment WHERE id_news = ?1 AND level = 1 LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Comment> getListCommentLevelOneByIdNews(Long idNews,int offset,int limit);

  @Query(value = "SELECT * FROM comment WHERE reply = ?1 AND level = 2 ORDER BY time_created DESC LIMIT ?2 , ?3 ",nativeQuery = true)
  List<Comment> getListCommentLevelTwoByIdNews(Long idNews,int offset,int limit);
}

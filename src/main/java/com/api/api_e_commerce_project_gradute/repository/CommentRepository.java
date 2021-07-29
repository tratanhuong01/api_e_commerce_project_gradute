package com.api.api_e_commerce_project_gradute.repository;

import com.api.api_e_commerce_project_gradute.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}

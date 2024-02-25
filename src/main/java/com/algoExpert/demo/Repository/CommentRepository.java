package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.Comment;
import com.algoExpert.demo.Entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}

package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

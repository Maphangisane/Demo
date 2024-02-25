package com.algoExpert.demo.Repository;

import com.algoExpert.demo.Entity.Table;
import com.algoExpert.demo.Entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<Table, Integer> {
}

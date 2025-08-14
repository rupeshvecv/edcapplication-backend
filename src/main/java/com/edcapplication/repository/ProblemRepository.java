package com.edcapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edcapplication.model.Problem;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Integer> {

}



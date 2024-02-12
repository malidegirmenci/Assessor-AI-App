package com.madtech.assessorai.repository;

import com.madtech.assessorai.entity.Question;

import java.util.List;
import java.util.Optional;

public interface IRepoQuestion {
    Question save(Question question);
    void deleteById(long id);
    List<Question> findAll();
    Optional<Question> findById(long id);
}

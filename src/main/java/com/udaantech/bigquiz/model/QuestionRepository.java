package com.udaantech.bigquiz.model;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

  Optional<Question> findByQuestionId(Long questionId);
}

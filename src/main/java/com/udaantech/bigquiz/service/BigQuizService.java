package com.udaantech.bigquiz.service;

import com.udaantech.bigquiz.model.MetaData;
import com.udaantech.bigquiz.model.Question;
import com.udaantech.bigquiz.model.QuestionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BigQuizService {

  @Autowired private QuestionRepository questionRepository;

  public Question getQuestion(Long id, boolean choice) {
    Optional<Question> found = questionRepository.findByQuestionId(id);

    Question foundQuestion = found.orElse(new Question());

    if (!found.isPresent()) {
      foundQuestion.setCode("E404");
      return foundQuestion;
    }

    if (!choice) {
      foundQuestion.setIncorrect(null);
    }

    return foundQuestion;
  }

  public Question saveQuestion(Question question) {
    return questionRepository.save(question);
  }

  public List<Question> saveQuestions(List<Question> questions) {
    return questionRepository.saveAll(questions);
  }

  public MetaData getMetaData() {
    MetaData metaData = new MetaData();
    metaData.setTotalQuestions(questionRepository.count());
    return metaData;
  }
}

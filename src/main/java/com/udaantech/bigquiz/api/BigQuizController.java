package com.udaantech.bigquiz.api;

import com.udaantech.bigquiz.model.MetaData;
import com.udaantech.bigquiz.model.Question;
import com.udaantech.bigquiz.service.BigQuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigQuizController {

  @Autowired private BigQuizService bigQuizService;

  @GetMapping(value = "question/{id}")
  public Object getQuestion(@PathVariable(value = "id") long questionId,
      @RequestParam(value = "choice", defaultValue = "false") boolean choice) {
    return bigQuizService.getQuestion(questionId, choice);
  }

  @PostMapping(value = "question")
  public Question saveQuestion(@RequestBody Question question) {
    return bigQuizService.saveQuestion(question);
  }

  @PostMapping(value = "questions")
  public List<Question> saveQuestions(@RequestBody List<Question> questions) {
    return bigQuizService.saveQuestions(questions);
  }

  @GetMapping(value = "metadata")
  public MetaData getMetaData() {
    return bigQuizService.getMetaData();
  }
}

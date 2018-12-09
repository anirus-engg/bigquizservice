package com.udaantech.bigquiz.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonInclude(Include.NON_NULL)
public class Question {

  @Id private String id;
  @Indexed(unique = true) private long questionId;
  @Indexed private String subject;
  private String question;
  private List<String> answers;
  private List<String> incorrect;
  private Difficulty difficulty;
  private float percentage;
  @Transient private String code;

  // Getters and Setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }

  public List<String> getIncorrect() {
    return incorrect;
  }

  public void setIncorrect(List<String> incorrect) {
    this.incorrect = incorrect;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public float getPercentage() {
    return percentage;
  }

  public void setPercentage(float percentage) {
    this.percentage = percentage;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}

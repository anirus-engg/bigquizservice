package com.udaantech.bigquiz.model;

import java.util.Arrays;
import java.util.List;

public class MetaData {

  private long totalQuestions;
  private List<Difficulty> difficultyLevels = Arrays.asList(Difficulty.values());

  // Getters and Setters

  public long getTotalQuestions() {
    return totalQuestions;
  }

  public void setTotalQuestions(long totalQuestions) {
    this.totalQuestions = totalQuestions;
  }

  public List<Difficulty> getDifficultyLevels() {
    return difficultyLevels;
  }
}

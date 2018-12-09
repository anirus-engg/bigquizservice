package com.udaantech.bigquiz.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "error")
public class Error {

  private String errorCode;
  private String description;

  public Error() {}

  public Error(String errorCode) {
    this.errorCode = errorCode;
  }

  // Getters and Setters

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

package com.evolutioncode.technicaltest.shared.exception.code;

import lombok.Getter;

@Getter
public enum MessageCode {

  TASK_DELETED_SUCCESSFULLY("MESS-01","Message.TASK_DELETED_SUCCESSFULLY");

  private final String code;
  private final String message;

  MessageCode(String code, String message) {
    this.code = code;
    this.message = message;
  }


}

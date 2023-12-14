package com.evolutioncode.technicaltest.shared.exception.code;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  TASK_NOT_FOUND("ERR-01", "Exception.TASK_NOT_FOUND"),
  TASK_ALREADY_EXISTS("ERR-02", "Exception.TASK_ALREADY_EXISTS"),
  TASK_DELETED_SUCCESS("MES-01", "Message.TASK_DELETED_SUCCESSFULLY"),
  TASK_SAVED_SUCCESSFULLY("MES-02", "Message.TASK_SAVED_SUCCESSFULLY"),
  TASK_UPDATED_SUCCESSFULLY("MES-03", "Message.TASK_UPDATED_SUCCESSFULLY");
  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
  }

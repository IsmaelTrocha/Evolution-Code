package com.evolutioncode.technicaltest.shared.exception.message.exception;

import com.evolutioncode.technicaltest.shared.exception.base.BaseException;
import com.evolutioncode.technicaltest.shared.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class TaskNotFoundException extends BaseException {

  public TaskNotFoundException(String message) {
    super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.TASK_NOT_FOUND);
  }
}

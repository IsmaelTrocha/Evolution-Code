package com.evolutioncode.technicaltest.shared.exception.message.exception;

import com.evolutioncode.technicaltest.shared.exception.base.BaseException;
import com.evolutioncode.technicaltest.shared.exception.code.ExceptionCode;
import com.evolutioncode.technicaltest.shared.exception.code.MessageCode;
import org.springframework.http.HttpStatus;

public class TaskDeletedSuccessfully extends BaseException {

  public TaskDeletedSuccessfully(String message){
    super(false, HttpStatus.OK,message, ExceptionCode.TASK_DELETED_SUCCESS);
  }
}

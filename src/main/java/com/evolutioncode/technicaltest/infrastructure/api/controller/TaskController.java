package com.evolutioncode.technicaltest.infrastructure.api.controller;

import com.evolutioncode.technicaltest.application.task.CreateTaskApplication;
import com.evolutioncode.technicaltest.application.task.GetTaskApplication;
import com.evolutioncode.technicaltest.application.task.TaskDeleteApplication;
import com.evolutioncode.technicaltest.application.task.UpdateTaskApplication;
import com.evolutioncode.technicaltest.infrastructure.api.dto.request.TaskRequest;
import com.evolutioncode.technicaltest.infrastructure.api.dto.request.TaskUpdateRequest;
import com.evolutioncode.technicaltest.infrastructure.api.dto.response.EntityResponse;
import com.evolutioncode.technicaltest.infrastructure.api.dto.response.TaskResponse;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.request.TaskRequestMapper;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.request.TaskUpdateRequestMapper;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.response.TaskResponseMapper;
import com.evolutioncode.technicaltest.shared.exception.code.ExceptionCode;
import com.evolutioncode.technicaltest.shared.utils.MessageUtils;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/task")
public class TaskController {

  private final CreateTaskApplication createTaskApplication;
  private final GetTaskApplication getTaskApplication;
  private final UpdateTaskApplication updateTaskApplication;
  private final TaskRequestMapper taskRequestMapper;
  private final TaskResponseMapper taskResponseMapper;
  private final TaskUpdateRequestMapper taskUpdateRequestMapper;
  private final TaskDeleteApplication taskDeleteApplication;
  private final MessageUtils messageUtils;

  @PostMapping
  public ResponseEntity<EntityResponse> createTask(@RequestBody TaskRequest taskRequest) {
    createTaskApplication.createTask(taskRequestMapper.toEntity(taskRequest));
    return new ResponseEntity<>(new EntityResponse(
        "200", messageUtils.getMessage(ExceptionCode.TASK_SAVED_SUCCESSFULLY.getType()),
        LocalDateTime.now()), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> updateTask(@RequestBody TaskUpdateRequest taskUpdateRequest) {
    updateTaskApplication.updateTask(taskUpdateRequestMapper.toEntity(taskUpdateRequest));
    return new ResponseEntity<Object>(new EntityResponse(
        "200", messageUtils.getMessage(ExceptionCode.TASK_UPDATED_SUCCESSFULLY.getType()),
        LocalDateTime.now()), HttpStatus.OK);
  }

  @GetMapping(value = "/retrieve/{id}")
  public ResponseEntity<TaskResponse> getTaskById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(taskResponseMapper.toDto(getTaskApplication.findTaskById(id)),
        HttpStatus.OK);
  }

  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<EntityResponse> removeTaskById(@PathVariable("id") Long id) {
    taskDeleteApplication.deleteTask(id);
    return new ResponseEntity<>(new EntityResponse(
        "200", messageUtils.getMessage(ExceptionCode.TASK_DELETED_SUCCESS.getType()),
        LocalDateTime.now()),
        HttpStatus.OK);
  }
}

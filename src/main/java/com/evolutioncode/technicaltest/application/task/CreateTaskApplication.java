package com.evolutioncode.technicaltest.application.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.CreateTaskService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskApplication {

  private final CreateTaskService createTaskService;

  public Task createTask(Task task) {
    task.setCreationDate(LocalDateTime.now());
    task.setIsActive(true);
    task.setIsFinished(false);
    return createTaskService.createTask(task);
  }

}

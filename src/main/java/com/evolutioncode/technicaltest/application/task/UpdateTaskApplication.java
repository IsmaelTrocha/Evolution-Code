package com.evolutioncode.technicaltest.application.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.UpdateTaskService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateTaskApplication {

  private final UpdateTaskService updateTaskService;

  public void updateTask(Task task) {
    task.setUpdatedDate(LocalDateTime.now());
    updateTaskService.updateTask(task);
  }
}

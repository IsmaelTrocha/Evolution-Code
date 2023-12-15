package com.evolutioncode.technicaltest.application.task;

import com.evolutioncode.technicaltest.domain.services.TaskMarkAsCompleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskMarkCompletedApplication {

  private final TaskMarkAsCompleteService taskMarkAsCompleteService;

  public void markTaskAsComplete(Long id) {
    taskMarkAsCompleteService.markTaskAsComplete(id);
  }

}

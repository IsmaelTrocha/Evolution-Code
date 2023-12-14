package com.evolutioncode.technicaltest.application.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.GetTaskService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetTaskApplication {

  private final GetTaskService getTaskService;

  public Task findTaskById(Long id) {
    return getTaskService.findTaskById(id);
  }

}

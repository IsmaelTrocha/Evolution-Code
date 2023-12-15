package com.evolutioncode.technicaltest.application.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.TaskDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskDeleteApplication {

  private final TaskDeleteService taskDeleteService;

  public void deleteTask(Long id){
    taskDeleteService.deleteTaskById(id);
  }

}

package com.evolutioncode.technicaltest.application;

import com.evolutioncode.technicaltest.application.task.CreateTaskApplication;
import com.evolutioncode.technicaltest.application.task.GetTaskApplication;
import com.evolutioncode.technicaltest.application.task.TaskDeleteApplication;
import com.evolutioncode.technicaltest.application.task.TaskMarkCompletedApplication;
import com.evolutioncode.technicaltest.application.task.UpdateTaskApplication;
import com.evolutioncode.technicaltest.domain.services.CreateTaskService;
import com.evolutioncode.technicaltest.domain.services.GetTaskService;
import com.evolutioncode.technicaltest.domain.services.TaskDeleteService;
import com.evolutioncode.technicaltest.domain.services.TaskMarkAsCompleteService;
import com.evolutioncode.technicaltest.domain.services.UpdateTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {

  @Bean
  public CreateTaskApplication createTaskApplication(CreateTaskService createTaskService) {
    return new CreateTaskApplication(createTaskService);
  }

  @Bean
  public GetTaskApplication getTaskApplication(GetTaskService getTaskService) {
    return new GetTaskApplication(getTaskService);
  }

  @Bean
  public UpdateTaskApplication updateTaskApplication(UpdateTaskService updateTaskService) {
    return new UpdateTaskApplication(updateTaskService);
  }

  @Bean
  public TaskDeleteApplication deleteTaskApplication(TaskDeleteService deleteTask) {
    return new TaskDeleteApplication(deleteTask);
  }

  @Bean
  public TaskMarkCompletedApplication taskMarkCompletedApplication(
      TaskMarkAsCompleteService taskMarkAsCompleteService) {
    return new TaskMarkCompletedApplication(taskMarkAsCompleteService);
  }
}

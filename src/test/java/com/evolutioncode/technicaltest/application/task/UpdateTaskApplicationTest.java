package com.evolutioncode.technicaltest.application.task;

import static org.mockito.Mockito.times;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.UpdateTaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

@ExtendWith(MockitoExtension.class)
public class UpdateTaskApplicationTest {

  @Mock
  private UpdateTaskService updateTaskService;

  @InjectMocks
  private UpdateTaskApplication updateTaskApplication;

  @Test
  @Description(value = "")
  void updateTaskTest() {
    Task task = new Task();

    updateTaskApplication.updateTask(task);
    Mockito.verify(updateTaskService, times(1)).updateTask(task);
  }
}
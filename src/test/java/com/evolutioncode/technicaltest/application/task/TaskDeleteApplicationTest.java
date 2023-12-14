package com.evolutioncode.technicaltest.application.task;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.evolutioncode.technicaltest.domain.services.TaskDeleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskDeleteApplicationTest {

  @Mock
  private TaskDeleteService taskDeleteService;

  @InjectMocks
  private TaskDeleteApplication taskDeleteApplication;

  @Test
  public void testDeleteTaskWhenTaskExistsThenTaskDeleted() {
    // Arrange
    Long taskId = 1L;

    // Act
    taskDeleteApplication.deleteTask(taskId);

    // Assert
    verify(taskDeleteService, times(1)).deleteTaskById(taskId);
  }

}
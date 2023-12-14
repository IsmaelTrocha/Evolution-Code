package com.evolutioncode.technicaltest.application.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.CreateTaskService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreateTaskApplicationTest {

  @Mock
  private CreateTaskService createTaskService;

  @InjectMocks
  private CreateTaskApplication createTaskApplication;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreateTaskWhenTaskIsCreatedThenReturnTask() {
    // Arrange
    Task task = new Task(1L, "Task 1", "Description 1", LocalDateTime.now(), null, null, true,
        false);
    when(createTaskService.createTask(task)).thenReturn(task);

    // Act
    Task result = createTaskApplication.createTask(task);

    // Assert
    assertEquals(task, result);
  }

}
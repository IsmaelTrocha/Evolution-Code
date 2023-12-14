package com.evolutioncode.technicaltest.application.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.GetTaskService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.query.Procedure;

@ExtendWith(MockitoExtension.class)
public class GetTaskApplicationTest {

  @Mock
  private GetTaskService getTaskService;

  private GetTaskApplication getTaskApplication;

  @BeforeEach
  public void setUp() {
    getTaskApplication = new GetTaskApplication(getTaskService);
  }

  @Description(value = "Test for the Retrieve of a Existing Task")
  @Test
  public void testFindTaskByIdWhenValidIdThenReturnTask() {
    // Arrange
    Long taskId = 1L;
    Task expectedTask = new Task(taskId, "Test Task", "This is a test task", LocalDateTime.now(),
        null, null, true, false);
    when(getTaskService.findTaskById(taskId)).thenReturn(expectedTask);

    // Act
    Task actualTask = getTaskApplication.findTaskById(taskId);

    // Assert
    assertEquals(expectedTask, actualTask);
  }

  @Description(value = "If the id that we are looking in the storage doesn't exists then we throw an Exception")
  @Test
  public void testFindTaskByIdWhenInvalidIdThenThrowException() {
    // Arrange
    Long taskId = 2L;
    when(getTaskService.findTaskById(taskId)).thenThrow(new RuntimeException("Task not found"));

    // Act & Assert
    assertThrows(RuntimeException.class, () -> getTaskApplication.findTaskById(taskId));
  }
}
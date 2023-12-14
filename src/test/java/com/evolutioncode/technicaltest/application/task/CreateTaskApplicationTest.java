package com.evolutioncode.technicaltest.application.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
    Task expected = new Task(1L, "Brush my teeth",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);
    when(createTaskService.createTask(any(Task.class))).thenReturn(expected);
    Task actual = createTaskService.createTask(expected);
    assertEquals(expected, actual);
  }

}
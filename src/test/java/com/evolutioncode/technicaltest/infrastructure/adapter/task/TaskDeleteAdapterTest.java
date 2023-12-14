package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import static org.mockito.Mockito.verify;

import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskDeleteAdapterTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private TaskDeleteAdapter taskDeleteAdapter;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testDeleteTaskByIdWhenValidIdThenTaskDeleted() {
    Long testId = 1L;

    taskDeleteAdapter.deleteTaskById(testId);

    verify(taskRepository).deleteById(testId);
  }

}
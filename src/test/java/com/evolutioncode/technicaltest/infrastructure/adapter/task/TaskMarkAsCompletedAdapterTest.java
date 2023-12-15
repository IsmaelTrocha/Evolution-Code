package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDto;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskMarkAsCompletedAdapterTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private TaskMarkAsCompletedAdapter taskMarkAsCompletedAdapter;

  private TaskDto taskDto;

  @BeforeEach
  public void setUp() {
    taskDto = new TaskDto();
    taskDto.setId(1L);
    taskDto.setIsFinished(false);
  }

  @Test
  public void testMarkTaskAsCompleteWhenTaskIsFoundThenTaskIsMarkedAsComplete() {
    when(taskRepository.findById(1L)).thenReturn(Optional.of(taskDto));

    taskMarkAsCompletedAdapter.markTaskAsComplete(1L);

    assertEquals(true, taskDto.getIsFinished());
    verify(taskRepository, times(1)).save(taskDto);
  }

  @Test
  public void testMarkTaskAsCompleteWhenTaskIsNotFoundThenTaskIsNotUpdated() {
    when(taskRepository.findById(1L)).thenReturn(Optional.empty());

    taskMarkAsCompletedAdapter.markTaskAsComplete(1L);

    verify(taskRepository, times(0)).save(any(TaskDto.class));
  }
}
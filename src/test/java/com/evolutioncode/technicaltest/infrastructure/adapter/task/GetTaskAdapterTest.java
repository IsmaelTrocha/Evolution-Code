package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDto;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDtoMapper;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetTaskAdapterTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private TaskDtoMapper taskDtoMapper;

  @InjectMocks
  private GetTaskAdapter getTaskAdapter;

  @Test
  void findTaskById() {
    Long id = 1L;
    Task expected = new Task(1L, "Task",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);

    TaskDto dto = new TaskDto(1L, "Task",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);

    Optional<TaskDto> taskDtoOptional = Optional.of(dto);

    Mockito.when(taskRepository.findById(id)).thenReturn(taskDtoOptional);
    Mockito.when(taskDtoMapper.toEntity(dto)).thenReturn(expected);
    Mockito.when(getTaskAdapter.findTaskById(id)).thenReturn(expected);
    Task actualTask = getTaskAdapter.findTaskById(id);

    Mockito.verify(taskRepository, Mockito.times(2)).findById(id);
    assertEquals(expected, actualTask);
  }
}

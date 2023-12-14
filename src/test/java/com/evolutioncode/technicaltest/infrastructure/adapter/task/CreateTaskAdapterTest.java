package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDto;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDtoMapper;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

@ExtendWith(MockitoExtension.class)
public class CreateTaskAdapterTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private TaskDtoMapper taskDtoMapper;

  @InjectMocks
  private CreateTaskAdapter createTaskAdapter;


  @Test
  @Description(value = "")
  void createTaskTest() {
    TaskDto dto = new TaskDto(1L, "Brush my teeth",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);
    Task expected = new Task(1L, "Brush my teeth",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);

    Mockito.when(taskDtoMapper.toEntity(any(TaskDto.class))).thenReturn(expected);

    Mockito.when(taskRepository.save(dto)).thenReturn(dto);

    Mockito.when(taskDtoMapper.toDto(any(Task.class))).thenReturn(dto);

    Task actual = createTaskAdapter.createTask(expected);

    assertEquals(expected, actual);

    Mockito.verify(taskRepository, Mockito.times(1)).save(dto);
  }
}

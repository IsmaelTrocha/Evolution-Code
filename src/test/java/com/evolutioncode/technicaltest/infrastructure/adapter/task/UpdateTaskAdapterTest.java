package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateTaskAdapterTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private UpdateTaskAdapter updateTaskAdapter;

  @Test
  void testUpdateTaskWhenTaskIsUpdatedThenSuccess() {
    // Arrange
    Task task = new Task();
    task.setId(1L);
    task.setName("Test Task");
    task.setDescription("This is a test controller");
    task.setCreationDate(LocalDateTime.now());
    task.setUpdatedDate(LocalDateTime.now());
    task.setFinishDate(LocalDateTime.now());
    task.setIsActive(true);
    task.setIsFinished(false);

    updateTaskAdapter.updateTask(task);


    verify(taskRepository, times(1)).updateTaskDto(task.getDescription(), task.getName(),
        task.getUpdatedDate(), task.getId());
  }

}

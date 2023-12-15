package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.UpdateTaskService;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateTaskAdapter implements UpdateTaskService {

  private final TaskRepository taskRepository;

  @Override
  @Transactional
  public void updateTask(Task task) {
    taskRepository.updateTaskDto(task.getDescription(),
        task.getName(),
        LocalDateTime.now(),
        task.getId());
  }
}

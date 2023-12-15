package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import com.evolutioncode.technicaltest.domain.services.TaskMarkAsCompleteService;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskMarkAsCompletedAdapter implements TaskMarkAsCompleteService {

  private final TaskRepository taskRepository;

  @Override
  public void markTaskAsComplete(Long id) {
    taskRepository.findById(id).ifPresent(task -> {
      task.setFinishDate(LocalDateTime.now());
      task.setIsFinished(Boolean.TRUE);
      taskRepository.save(task);
    });
  }
}

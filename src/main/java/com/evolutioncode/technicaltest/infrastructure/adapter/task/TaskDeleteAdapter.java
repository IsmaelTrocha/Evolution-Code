package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import com.evolutioncode.technicaltest.domain.services.TaskDeleteService;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskDeleteAdapter implements TaskDeleteService {

  private final TaskRepository taskRepository;

  @Override
  public void deleteTaskById(Long id) {
    taskRepository.deleteById(id);
  }
}

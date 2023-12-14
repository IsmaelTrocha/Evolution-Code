package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.CreateTaskService;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDtoMapper;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTaskAdapter implements CreateTaskService {

  private final TaskRepository taskRepository;
  private final TaskDtoMapper taskDtoMapper;

  @Override
  public Task createTask(Task task) {
    return taskDtoMapper.toEntity(taskRepository.save(taskDtoMapper.toDto(task)));
  }
}

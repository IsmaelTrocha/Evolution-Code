package com.evolutioncode.technicaltest.infrastructure.adapter.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.domain.services.GetTaskService;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskDtoMapper;
import com.evolutioncode.technicaltest.infrastructure.repository.task.TaskRepository;
import com.evolutioncode.technicaltest.shared.exception.code.ExceptionCode;
import com.evolutioncode.technicaltest.shared.exception.message.exception.TaskNotFoundException;
import com.evolutioncode.technicaltest.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetTaskAdapter implements GetTaskService {

  private final TaskRepository taskRepository;
  private final TaskDtoMapper taskDtoMapper;
  private final MessageUtils messageUtils;

  @Override
  public Task findTaskById(Long id) {
    return taskDtoMapper.toEntity(taskRepository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException(
            messageUtils.getMessage(
                ExceptionCode.TASK_NOT_FOUND.getType(), id.toString()
            ))));
  }
}

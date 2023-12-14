package com.evolutioncode.technicaltest.domain.services;

import com.evolutioncode.technicaltest.domain.entity.Task;

public interface GetTaskService {

  Task findTaskById(Long id);
}

package com.evolutioncode.technicaltest.infrastructure.repository.task;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskDtoMapper extends EntityToDto<Task, TaskDto> {

}

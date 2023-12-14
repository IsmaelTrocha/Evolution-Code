package com.evolutioncode.technicaltest.infrastructure.api.mapper.response;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.api.dto.response.TaskResponse;
import com.evolutioncode.technicaltest.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskResponseMapper extends EntityToDto<Task, TaskResponse> {

}

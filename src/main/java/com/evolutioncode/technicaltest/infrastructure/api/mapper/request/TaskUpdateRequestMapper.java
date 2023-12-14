package com.evolutioncode.technicaltest.infrastructure.api.mapper.request;

import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.api.dto.request.TaskUpdateRequest;
import com.evolutioncode.technicaltest.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskUpdateRequestMapper extends EntityToDto<Task, TaskUpdateRequest> {


}

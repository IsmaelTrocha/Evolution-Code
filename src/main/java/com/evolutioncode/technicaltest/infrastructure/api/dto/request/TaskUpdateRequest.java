package com.evolutioncode.technicaltest.infrastructure.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequest {

  private Long id;
  private String name;
  private String description;

}

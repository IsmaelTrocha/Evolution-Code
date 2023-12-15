package com.evolutioncode.technicaltest.infrastructure.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {

  private Long id;
  private String name;
  private String description;
  private LocalDateTime creationDate;
  private LocalDateTime finishDate;
  private Boolean isActive;
  private Boolean isFinished;
}

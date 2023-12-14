package com.evolutioncode.technicaltest.domain.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

  private Long id;
  private String name;
  private String description;
  private LocalDateTime creationDate;
  private LocalDateTime updatedDate;
  private LocalDateTime finishDate;
  private Boolean isActive;
  private Boolean isFinished;

}

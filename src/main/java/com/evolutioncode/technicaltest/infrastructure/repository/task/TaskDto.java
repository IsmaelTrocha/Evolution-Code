package com.evolutioncode.technicaltest.infrastructure.repository.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TASK")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TaskDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private LocalDateTime creationDate;
  private LocalDateTime updatedDate;
  private LocalDateTime finishDate;
  private Boolean isActive;
  private Boolean isFinished;

}

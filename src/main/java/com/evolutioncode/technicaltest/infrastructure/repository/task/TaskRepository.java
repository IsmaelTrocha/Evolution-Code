package com.evolutioncode.technicaltest.infrastructure.repository.task;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskDto, Long> {

  @Modifying
  @Query("UPDATE TaskDto "
      + "t SET t.description = :newDescription,"
      + "t.name = :newName,"
      + "t.updatedDate= :newUpdateDate"
      + " WHERE t.id = :id")
  void updateTaskDto(
      @Param("newDescription") String newDescription,
      @Param("newName") String newName,
      @Param("newUpdateDate") LocalDateTime updateDate,
      @Param("id") Long id
  );

}

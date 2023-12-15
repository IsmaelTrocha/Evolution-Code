package com.evolutioncode.technicaltest.application.task;

import static org.mockito.Mockito.verify;

import com.evolutioncode.technicaltest.domain.services.TaskMarkAsCompleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskMarkCompletedApplicationTest {

  @Mock
  private TaskMarkAsCompleteService taskMarkAsCompleteService;

  @InjectMocks
  private TaskMarkCompletedApplication taskMarkCompletedApplication;

  @Test
  void testMarkTaskAsCompleteWhenMethodCalledWithCorrectArgument() {
    Long id = 1L;

    taskMarkCompletedApplication.markTaskAsComplete(id);

    verify(taskMarkAsCompleteService).markTaskAsComplete(id);
  }

}

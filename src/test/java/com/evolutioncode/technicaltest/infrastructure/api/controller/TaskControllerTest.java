package com.evolutioncode.technicaltest.infrastructure.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.evolutioncode.technicaltest.application.task.CreateTaskApplication;
import com.evolutioncode.technicaltest.application.task.GetTaskApplication;
import com.evolutioncode.technicaltest.application.task.TaskDeleteApplication;
import com.evolutioncode.technicaltest.application.task.UpdateTaskApplication;
import com.evolutioncode.technicaltest.domain.entity.Task;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.request.TaskRequestMapper;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.request.TaskUpdateRequestMapper;
import com.evolutioncode.technicaltest.infrastructure.api.mapper.response.TaskResponseMapper;
import com.evolutioncode.technicaltest.shared.utils.MessageUtils;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

  private MockMvc mockMvc;
  @Mock
  private CreateTaskApplication createTaskApplication;
  @Mock
  private GetTaskApplication getTaskApplication;
  @Mock
  private UpdateTaskApplication updateTaskApplication;
  @Mock
  private TaskRequestMapper taskRequestMapper;
  @Mock
  private TaskResponseMapper taskResponseMapper;
  @Mock
  private TaskUpdateRequestMapper taskUpdateRequestMapper;
  @Mock
  private TaskDeleteApplication taskDeleteApplication;
  @Mock
  private MessageUtils messageUtils;

  @InjectMocks
  private TaskController taskController;

  @BeforeEach
  void setUp() {
    taskController = new TaskController(createTaskApplication, getTaskApplication,
        updateTaskApplication, taskRequestMapper, taskResponseMapper, taskUpdateRequestMapper,
        taskDeleteApplication, messageUtils);
    mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
  }

  @Test
  void getTaskById() throws Exception {
    Long id = 1L;
    Task task = buildTask();
    Mockito.when(getTaskApplication.findTaskById(id)).thenReturn(task);

    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/task/retrieve/" + id)
        .contentType(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    assertNotNull(result);
    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    Mockito.verify(getTaskApplication, Mockito.times(1)).findTaskById(id);
    Mockito.verify(taskResponseMapper, Mockito.times(1)).toDto(task);
  }

  private Task buildTask() {
    return new Task(1L, "Brush my teeth",
        "I have to brush my teeth every morning when i get up.", LocalDateTime.now(),
        LocalDateTime.now(), LocalDateTime.now(),
        true, true);
  }
}

package com.jwt.auth.controllers;

import com.jwt.auth.controller.UserController;
import com.jwt.auth.model.UserDto;
import com.jwt.auth.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.jwt.auth","com.jwt.auth.dao.mySql","com.jwt.auth.jwt","com.jwt.auth.service.impl"})

class UserControllerWebMvcTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  private WebTestClient webTestClient;

  @BeforeEach
  public void setup() {
    this.webTestClient = MockMvcWebTestClient
      .bindTo(mockMvc)
      .defaultHeader("X-Duke", "42")
      .filter(logRequest())
      .build();
  }


  @Test
  @WithMockUser(username = "testUser")
  void shouldReturnListOfUsersForAuthenticatedRequests() {
    when(userService.findAllUserDto())
      .thenReturn(List.of(new UserDto("testUser@gmail.com", "testUser","testUser"),
              new UserDto("testUser2@gmail.com", "testUser2","testUser2")));

    this.webTestClient
      .get()
      .uri("/users")
      .exchange()
      .expectStatus().is2xxSuccessful()
      .expectBody().jsonPath("$.size()", Matchers.is(2));
  }

  private ExchangeFilterFunction logRequest() {
    return (clientRequest, next) -> {
      System.out.printf("Request: %s %s %n", clientRequest.method(), clientRequest.url());
      return next.exchange(clientRequest);
    };
  }
}

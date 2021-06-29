package com.jwt.auth.controllers;

import com.jwt.auth.controller.RoleController;
import com.jwt.auth.model.mySql.Role;
import com.jwt.auth.service.RoleService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RoleController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.jwt.auth",
        "com.jwt.auth.dao.mySql",
        "com.jwt.auth.jwt",
        "com.jwt.auth.service.impl"})

class RoleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RoleService roleService;

  private WebTestClient webTestClient;



  @BeforeEach
  public void setup() {
    this.webTestClient = MockMvcWebTestClient
            .bindTo(mockMvc)
            .defaultHeader("X-Duke", "42")
            .filter(logRequest())
            .build();
  }


  private ExchangeFilterFunction logRequest() {
    return (clientRequest, next) -> {
      System.out.printf("Request: %s %s %n", clientRequest.method(), clientRequest.url());
      return next.exchange(clientRequest);
    };
  }

  @Test
  void shouldForbidAccessToUnauthenticatedRequests() throws Exception {
    this.mockMvc
            .perform(MockMvcRequestBuilders.get("/roles"))
            .andExpect(status().is4xxClientError());
  }

  @Test
  @WithMockUser(username = "test")
  void shouldReturnListOfRolesForAuthenticatedRequests() {
    Role role1=new Role();
    role1.setRoleId(1);
    role1.setRole("WU");

    Role role2=new Role();
    role2.setRoleId(1);
    role2.setRole("IBANK");


    when(roleService.findAll())
            .thenReturn(List.of(role1, role2));

    this.webTestClient
            .get()
            .uri("/roles")
            .exchange()
            .expectStatus().is2xxSuccessful()
            .expectBody().jsonPath("$.size()", Matchers.is(2));
  }

}



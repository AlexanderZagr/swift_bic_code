package com.jwt.auth.controllers;

import com.jwt.auth.controller.TmpIdocDepartmentController;
import com.jwt.auth.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@AutoConfigureRestDocs
@WebMvcTest(TmpIdocDepartmentController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.jwt.auth","com.jwt.auth.dao.mySql","com.jwt.auth.jwt","com.jwt.auth.service.impl"})

class TmpIdocDepartmentsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  private WebTestClient webTestClient;



  @TestConfiguration
  static class ResultHandlerConfiguration {

    @Bean
    public RestDocumentationResultHandler restDocumentation() {
      return MockMvcRestDocumentation.document("{method-name}");
    }
  }

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
  void allCustomers() throws Exception {
    this.webTestClient
            .get()
            .uri("/departments")
            .exchange()
            .expectStatus().is2xxSuccessful()
            .expectBody().jsonPath("$.size()", Matchers.is(2));
  }


}


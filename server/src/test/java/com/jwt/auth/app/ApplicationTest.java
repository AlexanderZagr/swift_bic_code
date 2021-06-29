package com.jwt.auth.app;

// JUnit Jupiter (part of JUnit 5)

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTest {

  @LocalServerPort
  private Integer port;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  void accessApplication() {
    System.out.println(port);
  }

  @Test
  void shouldForbidAccessToUnauthenticatedRequests() throws Exception {
    this.mockMvc
            .perform(MockMvcRequestBuilders.get("/roles"))
            .andExpect(status().is4xxClientError());
  }
}

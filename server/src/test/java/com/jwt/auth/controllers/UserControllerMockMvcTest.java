package com.jwt.auth.controllers;

import com.jwt.auth.controller.UserController;
import com.jwt.auth.exceptions.UserNotFoundException;
import com.jwt.auth.model.UserDto;
import com.jwt.auth.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.jwt.auth","com.jwt.auth.dao.mySql","com.jwt.auth.jwt","com.jwt.auth.service.impl"})
class UserControllerMockMvcTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;



  @Test
  @WithMockUser(username = "testUser")
  void shouldReturnListOfUsersForAuthenticatedRequests() throws Exception {

    when(userService.findAllUserDto())
            .thenReturn(List.of(new UserDto("testUser@gmail.com", "testUser","testUser"),
                    new UserDto("testUser2@gmail.com", "testUser2","testUser2"),
                    new UserDto("testUser3@gmail.com", "testUser3","testUser3")));

    this.mockMvc
      .perform(MockMvcRequestBuilders.get("/users"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.size()", Matchers.is(3)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"));
  }

    @Test
    public void shouldAllowDeletingReviewsWhenUserIsAdmin() throws Exception {
        this.mockMvc
                .perform(
                        delete("/users/1")
                                .with(SecurityMockMvcRequestPostProcessors.user("testUser").roles("ADMIN", "SUPER_USER"))
                                .with(csrf())
                )
                .andExpect(status().isOk());
    }


  @Test
  public void shouldRejectDeletingReviewsWhenUserIsNotAdmin() throws Exception {
    this.mockMvc
            .perform(delete("/users/1").with(csrf()))
            .andExpect(status().isUnauthorized());
  }

  @Test
  public void shouldReturn404WhenUserIsNotFound() throws Exception {
    when(userService.findOne("testUser"))
            .thenThrow(new UserNotFoundException("testUser is not found"));

    this.mockMvc
            .perform(get("/users/100"))
            .andExpect(status().isNotFound());
  }

  @Test
  public void shouldAllowCreationForUnauthenticatedUsers() throws Exception {
    this.mockMvc
            .perform(
                    post("/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"username\": \"testUser\", \"email\":\"testUser@gmail.com\"}")
                            .with(csrf())
            )
            .andExpect(status().isOk());

    verify(userService).save(any(UserDto.class));
  }

}

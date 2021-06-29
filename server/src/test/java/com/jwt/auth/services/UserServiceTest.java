package com.jwt.auth.services;

import com.jwt.auth.dao.mySql.UserDao;
import com.jwt.auth.model.UserDto;
import com.jwt.auth.model.mySql.User;
import com.jwt.auth.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.jwt.auth","com.jwt.auth.dao.mySql","com.jwt.auth.jwt","com.jwt.auth.service.impl"})
class UserServiceTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserDao customerRepository;

  @Test
  void shouldRegisterNewCustomer() {

    UserDto testUser=new UserDto();
    testUser.setPassword("12345");
    testUser.setName("test");
    testUser.setEmail("test11@gmail.com");
    testUser.setLastName("test");
    testUser.setActive(1);

    given(this.customerRepository.save(any()))
            .willReturn(testUser);

    UserDto cust=(UserDto) testUser;

    User result = userService.save(cust);

    assertEquals(testUser.getEmail(), result.getEmail());
  }

  @Test
  public void testGetById() {
    User testUser = new User();
    testUser.setEmail("test@gmail.com");
    testUser.setUserId(129);
    given(this.customerRepository.findById(any()))
            .willReturn(java.util.Optional.of(testUser));

    User person = userService.findById(129);
    System.out.println("test2 = "+person.getUserId());

    assertThat(person.getUserId()).isEqualTo(129);
  }
}

package com.example.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.config.Application;
import com.example.model.User;
import com.example.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@WebAppConfiguration
//@ActiveProfiles(profiles = "no-security") //TODO dlaczego nie ma security?
public class UserRestControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	private MockMvc mockMvc;

	private List<User> users = new ArrayList<>();

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private UserRepository userRepository;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		users.add(new User(1L, "first"));
		users.add(new User(2L, "second"));

		when(userRepository.findAll()).thenReturn(users);
	}

	@Test
	public void readAllUsers() throws Exception {
		mockMvc.perform(get("/users"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(this.users.get(0)
						.getId()
						.intValue())))
				.andExpect(jsonPath("$[0].name", is(this.users.get(0)
						.getName())))
				.andExpect(jsonPath("$[1].id", is(this.users.get(1)
						.getId()
						.intValue())))
				.andExpect(jsonPath("$[1].name", is(this.users.get(1)
						.getName())));
	}

}

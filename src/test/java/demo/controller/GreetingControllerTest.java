package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

@Autowired
private MockMvc mockMvc;

@MockBean
private GreetingService greetingService;

@Test
void helloReturnsGreeting() throws Exception {
given(greetingService.greeting("Anmol"))
.willReturn("Hello, Anmol");

mockMvc.perform(get("/hello").param("name", "Anmol"))
.andExpect(status().isOk())
.andExpect(content().string("Hello, Anmol"));
}

@Test
void healthReturnsOK() throws Exception {
mockMvc.perform(get("/health"))
.andExpect(status().isOk())
.andExpect(content().string("OK"));
}
}
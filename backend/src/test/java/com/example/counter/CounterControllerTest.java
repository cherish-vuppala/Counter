package com.example.counter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void incrementDecrementAndReset() throws Exception {
        mvc.perform(post("/api/counter/reset")).andExpect(jsonPath("$.value").value(0));
        mvc.perform(post("/api/counter/increment")).andExpect(jsonPath("$.value").value(1));
        mvc.perform(post("/api/counter/increment")).andExpect(jsonPath("$.value").value(2));
        mvc.perform(post("/api/counter/decrement")).andExpect(jsonPath("$.value").value(1));
        mvc.perform(get("/api/counter")).andExpect(status().isOk()).andExpect(jsonPath("$.value").value(1));
    }
}

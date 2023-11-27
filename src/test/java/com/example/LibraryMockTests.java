package com.example;


import com.example.model.Library;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class LibraryMockTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testGetAllFromLibrary() throws Exception{
        int expectedLength = 6;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Library[] libraries = mapper.readValue(contentAsString, Library[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, libraries.length),
                () -> assertEquals("Harry Potter", libraries[0].getTitle()),
                () -> assertEquals("The Hobbit", libraries[1].getTitle()),
                () -> assertEquals("Inception", libraries[2].getTitle()),
                () -> assertEquals("Fight Club", libraries[3].getTitle()),
                () -> assertEquals("The New Yorker", libraries[4].getTitle()),
                () -> assertEquals("National Geographic", libraries[5].getTitle()));
    }

}

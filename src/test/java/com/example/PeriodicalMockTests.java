package com.example;

import com.example.model.Movie;
import com.example.model.Periodicals;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql("classpath:test-data.sql")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class PeriodicalMockTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    ResultActions resultActions;


    @Test
    public void testCreatePeriodical() throws Exception {

       Periodicals periodicals = new Periodicals();

       periodicals.setPublicationDate("1999-01-01");
       periodicals.setTitle("The Article");
       periodicals.setId(5);



        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/periodicals")
                        .content(mapper.writeValueAsString(periodicals))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        periodicals = mapper.readValue(contentAsString, Periodicals.class);


        assertEquals(5, periodicals.getId());
        assertEquals("The Article", periodicals.getTitle());
        assertEquals("1999-01-01",periodicals.getPublicationDate());


    }

    @Test
    public void updatePeriodical() throws Exception {


        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/periodicals/6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Periodicals periodicals = mapper.readValue(contentAsString, Periodicals.class);

        System.out.println(periodicals.getTitle());

        periodicals.setTitle("Updated Periodical");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/periodicals/8")
                        .content(mapper.writeValueAsString(periodicals))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/periodicals/6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        periodicals = mapper.readValue(contentAsString, Periodicals.class);


        assertEquals("Updated Periodical", periodicals.getTitle());

    }
}

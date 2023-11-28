package com.example;

import com.example.model.Books;
import com.example.model.Movie;
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

@SpringBootTest
@Sql("classpath:test-data.sql")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class MovieMockTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    ResultActions resultActions;
@Test
    public void testCreateMovie() throws Exception {

        Movie movie = new Movie();
        movie.setGenre("Horror");
        movie.setTitle("Hooo");
        movie.setRating(9);
        movie.setDirector("Danny");
        movie.setLeadActor("Me");
        movie.setId(3);


        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);


        assertEquals(3, movie.getId());
        assertEquals("Hooo", movie.getTitle());
        assertEquals(9,movie.getRating());
        assertEquals("Danny", movie.getDirector());
        assertEquals("Me", movie.getLeadActor());

    }

    @Test
    public void updateMovie() throws Exception {


        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Movie movie = mapper.readValue(contentAsString, Movie.class);

        System.out.println(movie.getTitle());

        movie.setTitle("Updated Movie");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/movies")
                        .content(mapper.writeValueAsString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        movie = mapper.readValue(contentAsString, Movie.class);


        assertEquals("Updated Movie", movie.getTitle());

    }

    @Test
    public void testDeleteMovie() throws Exception {

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Movie movie = mapper.readValue(contentAsString, Movie.class);

        System.out.println(movie.getTitle());



        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/movies/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result1 = resultActions.andReturn();
        String contentAsString1 = result1.getResponse().getContentAsString();

        Movie movies = mapper.readValue(contentAsString1, Movie.class);

        assertEquals("Inception", movie.getTitle());
        assertEquals("Nothing found", movies.getGenre());

    }

    @Test
    public void testGetAllMovies() throws Exception{

        int expectedLength = 2;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Movie[] movies = mapper.readValue(contentAsString, Movie[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, movies.length),
                () -> assertEquals("Inception", movies[0].getTitle()),
                () -> assertEquals("Fight Club", movies[1].getTitle()),
                () -> assertEquals("Drama", movies[1].getGenre()));


    }

}
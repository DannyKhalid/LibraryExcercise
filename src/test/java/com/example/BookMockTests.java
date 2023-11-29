package com.example;

import com.example.model.Books;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql("classpath:test-data.sql")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class BookMockTests {


    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    ResultActions resultActions;

    @Test
    public void testCreateBook() throws Exception {

        Books books = new Books();
        books.setAuthor("Blah");
        books.setTitle("New movie");
        books.setGenre("Horror");
        books.setId(1);


        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .content(mapper.writeValueAsString(books))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        books = mapper.readValue(contentAsString, Books.class);


        assertEquals(1, books.getId());
        assertEquals("Blah", books.getAuthor());
        assertEquals("Horror", books.getGenre());
        assertEquals("New movie", books.getTitle());

    }

    @Test
    public void updateBook() throws Exception {


        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Books book = mapper.readValue(contentAsString, Books.class);

        System.out.println(book.getAuthor());

        book.setAuthor("Updated Book");

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/books")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        result = resultActions.andReturn();
        contentAsString = result.getResponse().getContentAsString();

        book = mapper.readValue(contentAsString, Books.class);

        System.out.println(book.getId());
        assertEquals("Updated Book", book.getAuthor());

    }

    @Test
    public void testDeleteBook() throws Exception {



        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Books book = mapper.readValue(contentAsString, Books.class);

        System.out.println(book.getAuthor());



        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result1 = resultActions.andReturn();
        String contentAsString1 = result1.getResponse().getContentAsString();

        Books books = mapper.readValue(contentAsString1, Books.class);


        assertEquals("Nothing found", books.getAuthor());

    }

    @Test
    public void testGetAllBooks() throws Exception{

        int expectedLength = 2;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Books[] books = mapper.readValue(contentAsString, Books[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, books.length),
                () -> assertEquals("Harry Potter", books[0].getTitle()),
                () -> assertEquals("The Hobbit", books[1].getTitle()),
                () -> assertEquals("J.K Rowling", books[0].getAuthor()),
                () -> assertEquals("J.R.R. Tolkien", books[1].getAuthor()),
                () -> assertEquals("fantasy", books[0].getGenre()),
                () -> assertEquals("fantasy", books[1].getGenre()));


    }
}

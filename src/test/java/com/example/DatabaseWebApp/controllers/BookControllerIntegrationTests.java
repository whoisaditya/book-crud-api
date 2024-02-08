package com.example.DatabaseWebApp.controllers;


import com.example.DatabaseWebApp.TestDataUtil;
import com.example.DatabaseWebApp.domain.dto.AuthorDto;
import com.example.DatabaseWebApp.domain.dto.BookDto;
import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.entities.BookEntity;
import com.example.DatabaseWebApp.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testThatCreateBookSuccessfullyReturnsHttp201Created() throws Exception {
        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);

        String testBookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookJson)

        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateBookSuccessfullyReturnsSavedBook() throws Exception {
        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);

        String testBookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("70-57-64-82-83")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("The secret life of Aditya Mitra")
        );
    }

    @Test
    public void testThatListBooksReturnsHttp200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatListBooksReturnsListOfBooks() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].isbn").value("70-57-64-82-83")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].title").value("The secret life of Aditya Mitra")
        );
    }
}

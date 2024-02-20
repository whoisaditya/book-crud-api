package com.example.DatabaseWebApp.controllers;


import com.example.DatabaseWebApp.TestDataUtil;
import com.example.DatabaseWebApp.domain.dto.BookDto;
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
    public void testThatUpdateBookSuccessfullyReturnsHttp200Ok() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedTestBookEntityA = bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setIsbn(savedTestBookEntityA.getIsbn());

        String testBookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
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
    public void testThatUpdateBookSuccessfullyReturnsUpdateBook() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedTestBookEntityA = bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setIsbn(savedTestBookEntityA.getIsbn());
        testBookDtoA.setTitle("UPDATED");

        String testBookJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + testBookDtoA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("70-57-64-82-83")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("UPDATED")
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
                MockMvcResultMatchers.jsonPath("$.content[0].isbn").value("70-57-64-82-83")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].title").value("The secret life of Aditya Mitra")
        );
    }

    @Test
    public void testThatGetBookReturnsHttpStatus200WhenBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatGetBookReturnsHttpStatus404WhenNoBookExists() throws Exception {
        BookEntity testBookEntityB = TestDataUtil.createTestBookEntityB(null);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + testBookEntityB.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatGetBookReturnsBookWhenBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("70-57-64-82-83")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("The secret life of Aditya Mitra")
        );
    }

    @Test
    public void testThatPartialUpdateBookReturnsHttpStatus200WhenBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setTitle("UPDATED");

        String testBookDtoAJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookDtoAJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatPartialUpdateBookReturnsHttpStatus404WhenNoBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setTitle("UPDATED");

        String testBookDtoAJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookDtoAJson)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );

    }

    @Test
    public void testThatPartialUpdateBookReturnsUpdatedBook() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto testBookDtoA = TestDataUtil.createTestBookDtoA(null);
        testBookDtoA.setTitle("UPDATED");

        String testBookDtoAJson = objectMapper.writeValueAsString(testBookDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBookDtoAJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(testBookEntityA.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("UPDATED")
        );
    }

    @Test
    public void testThatDeleteReturnsHttpStatus204WhenBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.save(testBookEntityA.getIsbn(), testBookEntityA);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent()
        );
    }

    @Test
    public void testThatDeleteReturnsHttpStatus204WhenNoBookExists() throws Exception {
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent()
        );
    }
}

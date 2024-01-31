package com.example.DatabaseWebApp.dao.impl;

import com.example.DatabaseWebApp.dao.impl.BookDaoImpl;
import com.example.DatabaseWebApp.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSQL() {
        Book book = Book.builder()
                .isbn("70-57-64-82-83")
                .title("The secret life of Aditya Mitra")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, authorId VALUES(?,?,?)"),
                eq("70-57-64-82-83"), eq("The secret life of Aditya Mitra"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSQL()  {
        underTest.find("70-57-64-82-83");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, authorId FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("70-57-64-82-83")
        );
    }
}

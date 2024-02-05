package com.example.DatabaseWebApp.dao.impl;

import com.example.DatabaseWebApp.TestDataUtil;
import com.example.DatabaseWebApp.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("70-57-64-82-83"), eq("The secret life of Aditya Mitra"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSQL()  {
        underTest.findOne("70-57-64-82-83");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("70-57-64-82-83")
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSQL() {
        underTest.find();
        verify(jdbcTemplate).query(eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("70-57-64-82-83", book);

        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq("70-57-64-82-83"), eq("The secret life of Aditya Mitra"), eq(1L), eq("70-57-64-82-83")
        );
    }
}

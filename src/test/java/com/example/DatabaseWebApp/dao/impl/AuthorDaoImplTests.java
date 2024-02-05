package com.example.DatabaseWebApp.dao.impl;


import com.example.DatabaseWebApp.TestDataUtil;
import com.example.DatabaseWebApp.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSQL() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Aditya Mitra"), eq(21)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSQL()  {
        underTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSQL() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
    }

    @Test
    public void thatThatUpdateGeneratesCorrectSQL() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.update(3L,author);

        verify(jdbcTemplate).update(
                eq("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?"),
                eq(1L), eq("Aditya Mitra"), eq(21), eq(3L)
        );
    }

    @Test
    public void thatThatDeleteGeneratesCorrectSQL() {
        underTest.delete(1L);

        verify(jdbcTemplate).update(
                eq("DELETE FROM authors WHERE id = ?"),
                eq(1L)
        );
     }
}

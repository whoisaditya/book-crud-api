package com.example.DatabaseWebApp.dao.impl;

import com.example.DatabaseWebApp.dao.AuthorDao;
import com.example.DatabaseWebApp.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
        );
    }

    @Override
    public Optional findOne(Author author) {
        return Optional.empty();
    }
}

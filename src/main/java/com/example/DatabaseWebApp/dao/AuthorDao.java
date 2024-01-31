package com.example.DatabaseWebApp.dao;

import com.example.DatabaseWebApp.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}

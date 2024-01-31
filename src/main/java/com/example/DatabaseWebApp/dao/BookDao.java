package com.example.DatabaseWebApp.dao;

import com.example.DatabaseWebApp.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}

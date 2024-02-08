package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.BookEntity;

import java.util.List;

public interface BookService {

    public BookEntity save(String isbn, BookEntity bookEntity);

    public List<BookEntity> findAll();
}

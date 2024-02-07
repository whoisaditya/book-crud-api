package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.BookEntity;

public interface BookService {

    public BookEntity createBook(String isbn, BookEntity bookEntity);
}

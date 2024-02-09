package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public BookEntity save(String isbn, BookEntity bookEntity);

    public List<BookEntity> findAll();

    public Page<BookEntity> findAll(Pageable pageable);

    public Optional<BookEntity> findOne(String isbn);

    public boolean isExists(String isbn);

    public BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    public void delete(String isbn);
}

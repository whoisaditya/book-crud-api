package com.example.DatabaseWebApp.services.impl;

import com.example.DatabaseWebApp.domain.entities.BookEntity;
import com.example.DatabaseWebApp.repositories.BookRepository;
import com.example.DatabaseWebApp.services.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity save(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(bookRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }
}

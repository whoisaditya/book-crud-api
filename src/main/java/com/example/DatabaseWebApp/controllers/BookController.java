package com.example.DatabaseWebApp.controllers;

import com.example.DatabaseWebApp.domain.dto.BookDto;
import com.example.DatabaseWebApp.domain.entities.BookEntity;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private Mapper<BookEntity, BookDto> bookMapper;

    @Autowired
    private BookService bookService;

    @PutMapping("books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public List<BookDto> listBooks() {
        List<BookEntity> books = bookService.findAll();

        return books
                .stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

}

package com.example.DatabaseWebApp.controllers;

import com.example.DatabaseWebApp.domain.dto.BookDto;
import com.example.DatabaseWebApp.domain.entities.BookEntity;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private Mapper<BookEntity, BookDto> bookMapper;

    @Autowired
    private BookService bookService;

    @PutMapping("books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);

        BookEntity savedBookEntity = bookService.save(isbn, bookEntity);
        BookDto savedBookDto =  bookMapper.mapTo(savedBookEntity);

        if (bookExists) {
            //update
            return new ResponseEntity<>(savedBookDto, HttpStatus.OK);
        } else {
            // create
            return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
        }
    }

    @GetMapping("/books")
    public List<BookDto> listBooks() {
        List<BookEntity> books = bookService.findAll();

        return books
                .stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        Optional<BookEntity> foundBookEntity = bookService.findOne(isbn);

        return foundBookEntity.map(bookEntity -> {
            BookDto bookDto = bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("books/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        if(!bookService.isExists(isbn)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);

        return new ResponseEntity<>(bookMapper.mapTo(updatedBookEntity), HttpStatus.OK);
    }


    @DeleteMapping("books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

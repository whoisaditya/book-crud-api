package com.example.DatabaseWebApp.controllers;

import com.example.DatabaseWebApp.domain.dto.BookDto;
import com.example.DatabaseWebApp.domain.entities.BookEntity;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// Controller Advice
// Rest Template
@RestController
@RequestMapping("/books")
public class BookController {

    Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private Mapper<BookEntity, BookDto> bookMapper;

    @Autowired
    private BookService bookService;

    @PutMapping("/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        logger.info("--> Entering createUpdateBook method of BookController class");

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);

        BookEntity savedBookEntity = bookService.save(isbn, bookEntity);
        BookDto savedBookDto =  bookMapper.mapTo(savedBookEntity);

        logger.info("<-- Exiting createUpdateBook method of BookController class");

        if (bookExists) {
            //update
            return new ResponseEntity<>(savedBookDto, HttpStatus.OK);
        } else {
            // create
            return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
        }
    }

    @GetMapping()
    public Page<BookDto> listBooks(Pageable pageable) {
        logger.info("--> Entering listBooks method of BookController class");

        Page<BookEntity> books = bookService.findAll(pageable);

        logger.info("<-- Exiting listBooks method of BookController class");

        return books.map(bookMapper::mapTo);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        logger.info("--> Entering getBook method of BookController class");

        Optional<BookEntity> foundBookEntity = bookService.findOne(isbn);

        logger.info("<-- Exiting getBook method of BookController class");

        return foundBookEntity.map(bookEntity -> {
            BookDto bookDto = bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        logger.info("--> Entering partialUpdateBook method of BookController class");

        if(!bookService.isExists(isbn)) {
            logger.info("<-- Empty/Bad Request");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);

        logger.info("<-- Exiting partialUpdateBook method of BookController class");

        return new ResponseEntity<>(bookMapper.mapTo(updatedBookEntity), HttpStatus.OK);
    }


    @DeleteMapping("/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn) {
        logger.info("--> Entering deleteBook method of BookController class");

        bookService.delete(isbn);

        logger.info("<-- Exiting deleteBook method of BookController class");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

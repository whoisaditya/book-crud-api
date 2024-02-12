package com.example.DatabaseWebApp.controllers;


import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.dto.AuthorDto;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.AuthorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    @PostMapping(path = "/")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        logger.info("--> Entering createAuthor method of AuthorController class");

        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);

        logger.info("<-- Exiting createAuthor method of AuthorController class");

        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping()
    public Page<AuthorDto> listAuthors(Pageable pageable) {
        logger.info("--> Entering listAuthors method of AuthorController class");

        Page<AuthorEntity> authors = authorService.findAll(pageable);

        logger.info("<-- Exiting listAuthors method of AuthorController class");

        return authors.map(authorMapper::mapTo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long id) {
        logger.info("--> Entering getAuthor method of AuthorController class");

        Optional<AuthorEntity> foundAuthorEntity = authorService.findOne(id);

        logger.info("<-- Exiting getAuthor method of AuthorController class");

        return foundAuthorEntity.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
        logger.info("--> Entering fullUpdateAuthor method of AuthorController class");
        if(!authorService.isExists(id)) {
            logger.info("<-- Empty/Bad Request");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        authorDto.setId(id);
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);

        logger.info("<-- Exiting fullUpdateAuthor method of AuthorController class");

        return  new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorDto> partialUpdateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
        logger.info("--> Entering partialUpdateAuthor method of AuthorController class");

        if(!authorService.isExists(id)) {

            logger.info("<-- Empty/Bad Request");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity updatedAuthorEntity = authorService.partialUpdate(id, authorEntity);

        logger.info("<-- Exiting partialUpdateAuthor method of AuthorController class");

        return new ResponseEntity<>(authorMapper.mapTo(updatedAuthorEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Long id) {
        logger.info("--> Entering deleteAuthor method of AuthorController class");

        authorService.delete(id);

        logger.info("<-- Exiting deleteAuthor method of AuthorController class");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

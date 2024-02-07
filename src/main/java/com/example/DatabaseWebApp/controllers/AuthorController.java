package com.example.DatabaseWebApp.controllers;


import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.dto.AuthorDto;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
//        System.out.println(savedAuthorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }
}

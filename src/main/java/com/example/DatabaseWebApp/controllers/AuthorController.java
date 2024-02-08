package com.example.DatabaseWebApp.controllers;


import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.dto.AuthorDto;
import com.example.DatabaseWebApp.mappers.Mapper;
import com.example.DatabaseWebApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDto> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();
        return authors
                .stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long id) {
        Optional<AuthorEntity> foundAuthorEntity = authorService.findOne(id);

        return foundAuthorEntity.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("authors/{id}")
    public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
        if(!authorService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        authorDto.setId(id);
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);

        return  new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.OK);
    }

    @PatchMapping("authors/{id}")
    public ResponseEntity<AuthorDto> partialUpdateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
        if(!authorService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity updatedAuthorEntity = authorService.partialUpdate(id, authorEntity);

        return new ResponseEntity<>(authorMapper.mapTo(updatedAuthorEntity), HttpStatus.OK);
    }
}

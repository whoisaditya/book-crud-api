package com.example.DatabaseWebApp.services.impl;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.repositories.AuthorRepository;
import com.example.DatabaseWebApp.services.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
//        System.out.println(authorEntity);
        return authorRepository.save(authorEntity);
    }
}

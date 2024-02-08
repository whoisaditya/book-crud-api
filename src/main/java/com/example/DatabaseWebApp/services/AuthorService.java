package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {

    public AuthorEntity save(AuthorEntity authorEntity);

    public List<AuthorEntity> findAll();
}

package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public AuthorEntity save(AuthorEntity authorEntity);

    public List<AuthorEntity> findAll();

    public Optional<AuthorEntity> findOne(Long id);

    public boolean isExists(Long id);

    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    public void delete(Long id);
}

package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public AuthorEntity save(AuthorEntity authorEntity);

    public List<AuthorEntity> findAll();

    public Optional<AuthorEntity> findOne(Long id);
}

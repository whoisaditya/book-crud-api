package com.example.DatabaseWebApp.services;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public AuthorEntity save(AuthorEntity authorEntity);

    public List<AuthorEntity> findAll();

    public Page<AuthorEntity> findAll(Pageable pageable);

    public Optional<AuthorEntity> findOne(Long id);

    public boolean isExists(Long id);

    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    public void delete(Long id);
}

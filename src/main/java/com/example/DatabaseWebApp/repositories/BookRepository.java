package com.example.DatabaseWebApp.repositories;

import com.example.DatabaseWebApp.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}

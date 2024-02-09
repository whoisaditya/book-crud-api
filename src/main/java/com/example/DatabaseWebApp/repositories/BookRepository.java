package com.example.DatabaseWebApp.repositories;

import com.example.DatabaseWebApp.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<BookEntity, String>, PagingAndSortingRepository<BookEntity, String> {
}

package com.example.DatabaseWebApp.repositories;

import com.example.DatabaseWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}

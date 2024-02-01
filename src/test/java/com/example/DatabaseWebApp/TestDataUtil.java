package com.example.DatabaseWebApp;

import com.example.DatabaseWebApp.domain.Author;
import com.example.DatabaseWebApp.domain.Book;

public class TestDataUtil {
    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Aditya Mitra")
                .age(21)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("70-57-64-82-83")
                .title("The secret life of Aditya Mitra")
                .authorId(1L)
                .build();
    }
}

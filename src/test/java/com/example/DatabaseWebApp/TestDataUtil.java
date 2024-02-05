package com.example.DatabaseWebApp;

import com.example.DatabaseWebApp.domain.Author;
import com.example.DatabaseWebApp.domain.Book;

public class TestDataUtil {
    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Aditya Mitra")
                .age(21)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Namya Arora")
                .age(22)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Atharva Shekatkar")
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

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

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("70-57-64-82-83")
                .title("The secret life of Aditya Mitra")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("98-76-54-32-10")
                .title("The tales of IDFC")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("01-23-45-67-89")
                .title("The journey of GDSC")
                .author(author)
                .build();
    }
}

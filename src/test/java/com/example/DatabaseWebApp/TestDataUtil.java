package com.example.DatabaseWebApp;

import com.example.DatabaseWebApp.domain.Author;

public class TestDataUtil {
    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Aditya Mitra")
                .age(21)
                .build();
    }
}

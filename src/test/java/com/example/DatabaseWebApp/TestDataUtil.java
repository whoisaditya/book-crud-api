package com.example.DatabaseWebApp;

import com.example.DatabaseWebApp.domain.dto.AuthorDto;
import com.example.DatabaseWebApp.domain.dto.BookDto;
import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import com.example.DatabaseWebApp.domain.entities.BookEntity;

public class TestDataUtil {
    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Aditya Mitra")
                .age(21)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Aditya Mitra")
                .age(21)
                .build();
    }

    public static AuthorEntity createTestAuthorEntityB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Namya Arora")
                .age(22)
                .build();
    }

    public static AuthorEntity createTestAuthorEntityC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Atharva Shekatkar")
                .age(21)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("70-57-64-82-83")
                .title("The secret life of Aditya Mitra")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("70-57-64-82-83")
                .title("The secret life of Aditya Mitra")
                .authorDto(authorDto)
                .build();
    }

    public static BookEntity createTestBookEntityB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("98-76-54-32-10")
                .title("The tales of IDFC")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookEntityC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("01-23-45-67-89")
                .title("The journey of GDSC")
                .authorEntity(authorEntity)
                .build();
    }
}

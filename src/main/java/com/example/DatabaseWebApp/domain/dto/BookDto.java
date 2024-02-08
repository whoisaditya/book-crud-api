package com.example.DatabaseWebApp.domain.dto;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String isbn;

    private String title;

    private AuthorDto author;
}

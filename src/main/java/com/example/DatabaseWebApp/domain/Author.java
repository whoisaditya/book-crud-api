package com.example.DatabaseWebApp.domain;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}

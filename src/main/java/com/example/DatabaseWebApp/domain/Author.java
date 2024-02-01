package com.example.DatabaseWebApp.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

}

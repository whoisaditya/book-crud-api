package com.example.DatabaseWebApp.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
//import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}

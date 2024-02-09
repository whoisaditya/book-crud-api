package com.example.DatabaseWebApp.repositories;

import com.example.DatabaseWebApp.domain.entities.AuthorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>, PagingAndSortingRepository<AuthorEntity, Long> {

    Iterable<AuthorEntity> ageLessThan(int age);

    @Query("SELECT a from com.example.DatabaseWebApp.domain.entities.AuthorEntity a where a.age > :age")
    Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(@Param("age") int age);
}

package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}

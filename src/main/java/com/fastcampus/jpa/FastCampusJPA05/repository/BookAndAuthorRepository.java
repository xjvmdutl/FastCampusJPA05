package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor,Long> {
}

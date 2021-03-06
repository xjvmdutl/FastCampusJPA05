package com.fastcampus.jpa.FastCampusJPA05.service;

import com.fastcampus.jpa.FastCampusJPA05.domain.Author;
import com.fastcampus.jpa.FastCampusJPA05.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void putAuthor(){
        Author author = new Author();
        author.setName("martin");
        authorRepository.save(author);
    }
}

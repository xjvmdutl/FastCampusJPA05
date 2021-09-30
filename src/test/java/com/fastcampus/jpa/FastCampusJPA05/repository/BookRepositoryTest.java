package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;


    @Test
    public void bookTest(){
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setAuthorId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    public void softDelete(){
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));
    }

    @Test
    public void queryTest(){
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual : "
                + bookRepository.findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual(
                        "JPA 초격차 패키지", LocalDateTime.now().minusDays(1L),LocalDateTime.now().minusDays(1L)
        ));
        System.out.println("findByNameRecently : " + bookRepository.findByNameRecently(
                "JPA 초격차 패키지", LocalDateTime.now().minusDays(1L),LocalDateTime.now().minusDays(1L)
        ));

        System.out.println(bookRepository.findBookNameAndCategory());

        bookRepository.findBookNameAndCategory().forEach(tuple -> {
            System.out.println(tuple.get(0) + " : " + tuple.get(1));
        });
    }
}

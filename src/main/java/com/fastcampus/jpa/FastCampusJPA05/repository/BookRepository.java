package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.Book;
import com.fastcampus.jpa.FastCampusJPA05.repository.dto.BookNameAndCategory;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Modifying
    @Query(value = "update book set category='none'",nativeQuery = true)
    public void update();

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual(String name, LocalDateTime createdAt,LocalDateTime updatedAt);
    /*
    @Query(value = "SELECT b FROM Book b"
         + " WHERE NAME = ?1 AND CREATE_AT >= ?2 AND UPDATE_AT >= ?3 AND CATEGORY IS NULL")
    */
    @Query(value = "SELECT b FROM Book b"
            + " WHERE NAME = :name AND CREATE_AT >= :createAt AND UPDATE_AT >= :updateAt AND CATEGORY IS NULL")
    List<Book> findByNameRecently(@Param("name") String name,@Param("createAt") LocalDateTime createdAt,@Param("updateAt") LocalDateTime updatedAt);

    @Query(value = "select b.name as name, b.category as category from Book b")
    List<Tuple> findBookNameAndCategory();
}

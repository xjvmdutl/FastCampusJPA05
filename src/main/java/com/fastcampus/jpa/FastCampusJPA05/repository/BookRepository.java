package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.Book;
import com.fastcampus.jpa.FastCampusJPA05.repository.dto.BookNameAndCategory;
import jdk.jfr.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    //@Query(value = "select b.name as name, b.category as category from Book b")
    @Query(value = "select new com.fastcampus.jpa.FastCampusJPA05.repository.dto.BookNameAndCategory(b.name , b.category) from Book b")//JQQL이기에 가능하다(자바 문법이 들어간다)
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.fastcampus.jpa.FastCampusJPA05.repository.dto.BookNameAndCategory(b.name , b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);


    //Native쿼리일 경우 java 문법을 사용 x,스네이크 케이스로 표기 해야된다.
    @Query(value = "SELECT * FROM book" ,nativeQuery = true)
    List<Book> findAllCustom();

    @Transactional//native 쿼리를 실행할 경우 직접 트렌젝션을 설정해야된다.
    @Modifying//업데이트라는 것을 표기하여 int형에 update한 것을 넣어준다
    @Query(value = "update book set category='IT전문서'",nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();//일반적 JPA로 생성 불가능, native쿼리로 생성

    @Query(value = "SELECT * FROM book ORDER BY id DESC limit 1",nativeQuery = true)
    Map<String,Object> findRowRecord();
}

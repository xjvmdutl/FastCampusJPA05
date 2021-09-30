package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

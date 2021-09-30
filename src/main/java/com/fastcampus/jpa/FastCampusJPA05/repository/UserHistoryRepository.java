package com.fastcampus.jpa.FastCampusJPA05.repository;

import com.fastcampus.jpa.FastCampusJPA05.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {
    List<UserHistory> findByUserId(Long userId);
}

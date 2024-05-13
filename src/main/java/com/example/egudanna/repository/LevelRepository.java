package com.example.egudanna.repository;

import com.example.egudanna.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    Level findLevelById(Long id);
}

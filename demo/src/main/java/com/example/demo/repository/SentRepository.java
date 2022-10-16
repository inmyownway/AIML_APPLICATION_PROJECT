package com.example.demo.repository;

import com.example.demo.db.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SentRepository extends JpaRepository<Sentence,Integer> {
    @Query("SELECT s FROM Sentence s WHERE s.cafe_id = :cafe_id")
    public List<Sentence> findByCafe_id(int cafe_id);
}

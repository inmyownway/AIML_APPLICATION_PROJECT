package com.example.demo.repository;

import com.example.demo.db.Cafe;
import com.example.demo.db.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
    @Query("SELECT s FROM Cafe s WHERE s.cafe_id = :cafe_id")
    public List<Cafe> findByCafe_id(int cafe_id);
}

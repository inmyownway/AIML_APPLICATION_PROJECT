package com.example.demo.repository;

import com.example.demo.db.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
    //@Query(value = "SELECT c FROM cafe c WHERE c.name LIKE %:word%")
    //<Cafe> findAllSearch(String word);
}

package com.example.demo.repository;

import com.example.demo.db.Cafe;
import com.example.demo.dto.CafeDto;
import com.example.demo.dto.CafeFilterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
    @Query("SELECT c FROM Cafe c WHERE c.cafe_name LIKE %:name%")
    List<Cafe> findByCafe_nameContaining(String name);
}

package com.example.demo.repository;

import com.example.demo.db.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {}

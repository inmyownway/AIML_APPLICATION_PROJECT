package com.example.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CafeRepository extends JpaRepository<Cafe,Integer> {

}

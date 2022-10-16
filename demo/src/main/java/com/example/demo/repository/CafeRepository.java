package com.example.demo.repository;

import com.example.demo.db.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
//    @Query("SELECT u FROM UserEntity u WHERE u.name = :name")
//    List<UserEntity> findByName(String name);
}

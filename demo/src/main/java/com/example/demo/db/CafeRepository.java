package com.example.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
//    @Query("SELECT u FROM UserEntity u WHERE u.name = :name")
//    List<UserEntity> findByName(String name);
}

package com.example.demo.db;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe_db")
@Entity

public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
     private int cafe_id;
    @Column(length = 200, nullable = false)
    private String cafe_name;

}

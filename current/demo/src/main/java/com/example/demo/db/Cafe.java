package com.example.demo.db;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe_info")
@Entity

public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Integer cafe_id;

    @Column(length = 20, nullable = false)
    private String cafe_name;

    @Column(length = 50, nullable = false)
    private String cafe_place;

    @Column(length = 5, nullable = false)
    private Integer key1;
    private Integer key2;
    private Integer key3;
}

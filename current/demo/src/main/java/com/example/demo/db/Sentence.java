package com.example.demo.db;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe_sen")
@Entity

public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Integer sent_id;

    @Column(name="cafe_id" )
    private Integer cafe_id;

    @Column(length = 50, nullable = false)
    private String sen_key;

    @Column(length = 5, nullable = false)
    private Integer key_num;
}

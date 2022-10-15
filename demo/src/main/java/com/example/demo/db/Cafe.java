package com.example.demo.db;



import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="cafe_info")
@Entity

public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Integer cafe_id;

    @Column(length = 200, nullable = false)
    private String cafe_name;

}

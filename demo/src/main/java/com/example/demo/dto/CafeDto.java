package com.example.demo.dto;

import com.example.demo.db.Cafe;
import lombok.*;

//Controller와 Service 사이에서 데이터를 주고 받는 DTO
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CafeDto {
    private int cafe_id;
    private String cafe_name;

    public Cafe toEntity(){
        Cafe cafe = Cafe.builder()
                .cafe_id(cafe_id)
                .cafe_name(cafe_name)
                .build();
        return cafe;
    }

    @Builder
    public CafeDto(int cafe_id, String cafe_name){
        this.cafe_id = cafe_id;
        this.cafe_name = cafe_name;
    }
}

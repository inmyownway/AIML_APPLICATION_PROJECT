package com.example.demo.dto;

import com.example.demo.db.Cafe;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//Controller와 Service 사이에서 데이터를 주고 받는 DTO
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CafeDto {
    private int cafe_id;
    private String cafe_name;
    private String cafe_place;

    private List<Integer> key_num;
    public Cafe toEntity(){
        Cafe cafe = Cafe.builder()
                .cafe_id(cafe_id)
                .cafe_name(cafe_name)
                .cafe_place(cafe_place)
                .key1(key_num.get(0))
                .key2(key_num.get(1))
                .key3(key_num.get(2))
                .build();
        return cafe;
    }

    @Builder
    public CafeDto(int cafe_id, String cafe_name, String cafe_place, int key1, int key2, int key3){
        key_num = new ArrayList<>();
        this.cafe_id = cafe_id;
        this.cafe_name = cafe_name;
        this.cafe_place = cafe_place;
        this.key_num.add(key1);
        this.key_num.add(key2);
        this.key_num.add(key3);
    }
}

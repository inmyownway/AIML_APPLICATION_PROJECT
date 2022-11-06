package com.example.demo.dto;

import lombok.*;

//Controller와 Service 사이에서 데이터를 주고 받는 DTO
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CafeFilterDTO {
    private int cafe_id;    //카페id
    private String cafe_name;   //카페이름
    private String[] labels;    //해당하는 키워드들

    public CafeFilterDTO(int cafe_id, String cafe_name, String labels){
        this.cafe_id = cafe_id;
        this.cafe_name = cafe_name;
        this.labels = labels.split(",");
    }
}

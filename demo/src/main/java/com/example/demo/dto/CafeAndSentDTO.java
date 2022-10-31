package com.example.demo.dto;

import com.example.demo.db.Sentence;;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CafeAndSentDTO {
    private int cafe_id;
    private String cafe_name;
    private String cafe_place;
    private List<Integer> key_num;
    private List<Sentence> sentList;
    public CafeAndSentDTO(CafeDto cafe, List<Sentence> sentList){
        this.cafe_id = cafe.getCafe_id();   //해당 카페의 id
        this.cafe_name = cafe.getCafe_name();   //해당 카페의 이름
        this.cafe_place = cafe.getCafe_place(); //해당 카페의 주소
        this.key_num = cafe.getKey_num();   //해당 카페의 키워드별 개수 리스트
        this.sentList = new ArrayList<>();
        this.sentList = sentList;   //해당 카페의 문장리스트
    }
}

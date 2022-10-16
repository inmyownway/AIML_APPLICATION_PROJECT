package com.example.demo.dto;

import com.example.demo.db.Cafe;
import com.example.demo.db.Sentence;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//Controller와 Service 사이에서 데이터를 주고 받는 DTO
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SentenceDto {
    //private int sent_id;
    private int cafe_id;
    private String sen_key;
    private int key_num;

    public Sentence toEntity(){
        Sentence sentence = Sentence.builder()
                //.sent_id(sent_id)
                .cafe_id(cafe_id)
                .sen_key(sen_key)
                .key_num(key_num)
                .build();
        return sentence;
    }

    @Builder
    public SentenceDto(int cafe_id, String sen_key, int key_num){
        //this.sent_id = sent_id;
        this.cafe_id = cafe_id;
        this.sen_key = sen_key;
        this.key_num = key_num;
    }
}

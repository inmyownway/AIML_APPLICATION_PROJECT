package com.example.demo.service;

import com.example.demo.dto.CafeDto;
import com.example.demo.dto.SentenceDto;
import com.example.demo.repository.SentRepository;
import com.example.demo.db.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SentService {

    @Autowired
    private SentRepository sentRepository;

    public SentService(SentRepository sentRepository){
        this.sentRepository = sentRepository;
    }

    /*
    public List<SentenceDto> getSentence(int id){
        List<SentenceDto> sentList = new ArrayList<>();
        List<Sentence> sentWrappers = sentRepository.findByCafe_id(id);
        for(Sentence sent : sentWrappers){
            SentenceDto sentenceDto = SentenceDto.builder()
                    .cafe_id(sent.getCafe_id())
                    .sen_key(sent.getSen_key())
                    .key_num(sent.getKey_num())
                    .build();
            sentList.add(sentenceDto);
        }
        return sentList;
    }*/
    public List<Sentence> getSentence(int id){
        return sentRepository.findByCafe_id(id);
    }
}


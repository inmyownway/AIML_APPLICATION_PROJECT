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

    public List<Sentence> getSentence(int id){
        return sentRepository.findByCafe_id(id);
    }
}


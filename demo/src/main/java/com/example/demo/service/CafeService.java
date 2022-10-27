package com.example.demo.service;

import com.example.demo.db.Cafe;
import com.example.demo.repository.CafeRepository;
import com.example.demo.dto.CafeDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CafeService {

    private CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository){
        this.cafeRepository = cafeRepository;
    }

    @Transactional
    public CafeDto getCafe(int id){
        Optional<Cafe> cafeWrapper = cafeRepository.findById(id);
        Cafe cafe = cafeWrapper.get();

        CafeDto cafeDto = CafeDto.builder()
                .cafe_id(cafe.getCafe_id())
                .cafe_name(cafe.getCafe_name())
                .cafe_place(cafe.getCafe_place())
                .key1(cafe.getKey1())
                .key2(cafe.getKey2())
                .key3(cafe.getKey3())
                .build();

        return cafeDto;
    }

    @Transactional
    public List<CafeDto> getCafelist(){
        List<Cafe> cafes = cafeRepository.findAll();
        List<CafeDto> cafeDtoList = new ArrayList<>();

        for(Cafe cafe : cafes){
            CafeDto cafeDto = CafeDto.builder()
                    .cafe_id(cafe.getCafe_id())
                    .cafe_name(cafe.getCafe_name())
                    .cafe_place(cafe.getCafe_place())
                    .key1(cafe.getKey1())
                    .key2(cafe.getKey2())
                    .key3(cafe.getKey3())
                    .build();
            cafeDtoList.add(cafeDto);
        }
        return cafeDtoList;
    }
}


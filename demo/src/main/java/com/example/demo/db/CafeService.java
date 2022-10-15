package com.example.demo.db;

import com.example.demo.dto.CafeDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
                .build();

        return cafeDto;
    }
}


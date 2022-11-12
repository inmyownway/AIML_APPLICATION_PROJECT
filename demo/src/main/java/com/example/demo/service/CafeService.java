package com.example.demo.service;

import com.example.demo.db.Cafe;
import com.example.demo.repository.CafeRepository;
import com.example.demo.dto.CafeDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
                .cafe_lat(cafe.getCafe_lat())
                .cafe_lng(cafe.getCafe_lng())
                .cnt(cafe.getCnt())
                .key1(cafe.getKey1())
                .key2(cafe.getKey2())
                .key3(cafe.getKey3())
                .key4(cafe.getKey4())
                .key5(cafe.getKey5())
                .key6(cafe.getKey6())
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
                    .cafe_lat(cafe.getCafe_lat())
                    .cafe_lng(cafe.getCafe_lng())
                    .cnt(cafe.getCnt())
                    .key1(cafe.getKey1())
                    .key2(cafe.getKey2())
                    .key3(cafe.getKey3())
                    .key4(cafe.getKey4())
                    .key5(cafe.getKey5())
                    .key6(cafe.getKey6())
                    .build();
            cafeDtoList.add(cafeDto);
        }
        return cafeDtoList;
    }

    @Transactional
    public List<CafeDto> getSearchList(String name, String filters){
        //String [] f = filters.split("");
        List<Cafe> cafes = cafeRepository.findByCafe_nameContaining(name);

        List<CafeDto> cafeDtoList = new ArrayList<>();
        for(Cafe cafe : cafes){
            CafeDto cafeDto = CafeDto.builder()
                    .cafe_id(cafe.getCafe_id())
                    .cafe_name(cafe.getCafe_name())
                    .cafe_place(cafe.getCafe_place())
                    .cafe_lat(cafe.getCafe_lat())
                    .cafe_lng(cafe.getCafe_lng())
                    .cnt(cafe.getCnt())
                    .key1(cafe.getKey1())
                    .key2(cafe.getKey2())
                    .key3(cafe.getKey3())
                    .key4(cafe.getKey4())
                    .key5(cafe.getKey5())
                    .key6(cafe.getKey6())
                    .build();
            cafeDtoList.add(cafeDto);
        }

        //// 2. 키워드(필터)로 거르기
        // TODO : 이 리스트(cafeDtoList)를 기준(10%)로 걸러서 새 리스트(??)에 넣어서 반환
        // 필터를 리스트로 쪼갠다 "111111" -> f = [1,1,1,1,1,1]
        String [] f = filters.split("");

        List<CafeDto> removeList = new ArrayList<>();

        for (int i = 0; i < 6; ++i) { // 각 키워드에 대해
            if (f[i].equals("1")) { // 검색 필터에 포함되는 키워드인 경우
                // cafeDtoList 중 이 키워드가 기준을 넘게 나온 카페를 선정
                for (CafeDto cafeDto : cafeDtoList) {
                    int cnt = cafeDto.getCnt();
                    int keyNum = cafeDto.getKey_num().get(i);
                    double rate = (double) keyNum / (double) cnt;

                    if (rate <= 0.1) {  // 비율 10퍼 이하인 경우
                        removeList.add(cafeDto);
                    }
                }
            }
        }
        // 중복제거
        Set<CafeDto> set = new HashSet<CafeDto>(removeList);  // List를 Set으로 변경
        List<CafeDto> tmp = new ArrayList<CafeDto>(set);  // Set을 List로 변경

        for (CafeDto cafe : tmp) {  // 검색 결과만 남기기
            cafeDtoList.remove(cafe);
        }
        System.out.println("final: " + cafeDtoList.size());


        return cafeDtoList;
    }
}


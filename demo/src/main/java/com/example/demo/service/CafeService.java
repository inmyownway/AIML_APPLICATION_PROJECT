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
        List<Integer> tmp2 = new ArrayList<Integer>();

        //필터 1인 키워드번호를 처음에 따로 저장해두고 > list1
        //if문 여섯 개 돌려서 6개 리스트에 키워드별 기준값 넘는카페 담아두기
        //저장해둔 list1에 있는 키워드에 대한ㄹ 리스트만 교집합 구하기

        for (int i = 0; i < 6; ++i) {
            if (f[i].equals("1")) { // 검색 필터에 포함되는 키워드인 경우
                // cafeDtoList 중 이 키워드가 기준을 넘게 나온 카페를 선정
                for (int j=0; j<cafeDtoList.size(); ++j) {
                    int cnt = cafeDtoList.get(j).getCnt(); // 총 리뷰 개수
                    int keyNum = cafeDtoList.get(j).getKey_num().get(i); // 키워드 해당하는 리뷰 개수
                    double rate = (double) keyNum / (double) cnt; // 비율값
                    System.out.println("rate:" + rate);
                    if (rate >= 0.1) {  // 비율 10퍼 이상
                        tmp2.add(j); // 인덱스를 저장
                    }
                }
            }
        }
        // 중복제거
        // List를 Set으로 변경
        Set<Integer> set = new HashSet<Integer>(tmp2);

        // Set을 List로 변경
        List<Integer> tmp =new ArrayList<Integer>(set);

        System.out.println("tmp list");
        for (int t : tmp) {
            System.out.print(t + ", ");
        }

        List<CafeDto> cafeDtoList2 = new ArrayList<>();
        for (int i=0; i<tmp.size(); ++i){
            cafeDtoList2.add(cafeDtoList.get(tmp.get(i)));
        }

//        for (CafeDto cafe : cafeDtoList) { // 각 cafe에 대해
//            for (int i = 0; i < 6; ++i) { // 각 키워드에 대해
//                if (f[i].equals("1")) { // 검색 필터에 포함되는 키워드인 경우
//                    // cafeDtoList 중 이 키워드가 기준을 넘게 나온 카페를 선정
//                    for (CafeDto cafeDto : cafeDtoList) {
//                        int cnt = cafeDto.getCnt();
//                        int keyNum = cafeDto.getKey_num().get(i);
//                        double rate = (double) cnt / (double) keyNum;
//                        if (rate < 0.1) {  // 비율 10퍼 이하인 경우
//                            cafeDtoList.remove(cafeDto); // cafeDtoList에서 삭제
//                        }
//                    }
//                }
//            }
//        }
        return cafeDtoList2;
    }
}


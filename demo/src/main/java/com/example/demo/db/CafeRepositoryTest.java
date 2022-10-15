package com.example.demo.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
// Read 테스트
//Select를 할 때 Repository 객체의 findById() 메소드를 사용합니다.
//findById()를 통해 기본키를 넣어주면, 해당하는 객체를 Optional 타입으로 반환해줍니다.
//

@SpringBootTest
public class CafeRepositoryTest {
    @Autowired
    CafeRepository cafeRepository;
    @Test
    public void SelectDummies() {



        Integer cafe_id =0;
        Optional<Cafe> result = cafeRepository.findById(cafe_id);
        System.out.println("=============================");
        if(result.isPresent()) {
            Cafe cafe = result.get();
            System.out.println(cafe+" @@");

        }
        System.out.println("=============================");

    }

}

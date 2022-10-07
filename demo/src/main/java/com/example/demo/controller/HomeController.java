package com.example.demo.controller;

import com.example.demo.object.Cafe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    //지도화면
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //세부정보화면
    @GetMapping("/more")
    public String cafeInfo(Model model){
        // 예시 적용해보기
        int id=0;
        String name="스타벅스홍대점";
        String[] label = {"키1","키2","키3","키4","키5","키6"};
        String[] key_cnt = {"12","999","30","45","555","60"};
        String[][] key_example = {{"조용함1","조용2","조용3"},{"공부1","공부2","공부3"},
                {"키3","키3","키3"},{"키4","키4","키4"},{"키5","키5","키5"}, {"키6","키6","키6"}};
        List<List<String>> temp = new ArrayList<>();
        for(int i=0; i<key_example.length; i++){
            List<String> temp2 = new ArrayList<>();
            temp2.add(label[i]);
            temp2.add(key_cnt[i]);
            for(int j=0;j<key_example[i].length; j++){
                temp2.add(key_example[i][j]);
            }temp.add(temp2);
        }
        model.addAttribute("cafe_id", id);
        model.addAttribute("cafe_name", name);
        model.addAttribute("cafe_keydata", temp);
        return "detailPage";
    }
    //검색창

}

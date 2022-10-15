package com.example.demo.controller;

import com.example.demo.service.CafeService;
import com.example.demo.dto.CafeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private CafeService cafeService;
    public HomeController(CafeService cafeService){
        this.cafeService = cafeService;
    }

    /* 지도화면 */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /* 세부정보화면*/
    @RequestMapping("/more")
    public String cafeInfo(@RequestParam("id") String id, Model model){
        String[] label = {"조용함","키2","키3"};
        String[][] key_example = {{"조용함1문자ㅏㅏㅏㅇㅇㅇㅇ","조용2","조용3"},{"공부1","공부2","공부3"}};
        List<List<String>> temp = new ArrayList<>();
        for(int i=0; i<key_example.length; i++){
            List<String> temp2 = new ArrayList<>();
            temp2.add(label[i]);
            for(int j=0;j<key_example[i].length; j++){
                temp2.add(key_example[i][j]);
            }temp.add(temp2);
        }
        // View로 값 전달
        model.addAttribute("cafe_keydata", temp);
        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
        model.addAttribute("cafeDto", cafeDto);
        return "detailPage";
    }
}

package com.example.demo.controller;

import com.example.demo.db.Cafe;
import com.example.demo.db.CafeRepository;
import com.example.demo.db.CafeService;
import com.example.demo.dto.CafeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        String[] label = {"조용함","키2","키3","키4","키5","키6"};
        String[] key_cnt = {"12","999","30","45","555","60"};
        String[][] key_example = {{"조용함1문자ㅏㅏㅏㅇㅇㅇㅇ","조용2","조용3"},{"공부1","공부2","공부3"},
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
        // View로 값 전달
        model.addAttribute("cafe_keydata", temp);

        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
        model.addAttribute("cafeDto", cafeDto);
        return "detailPage";
    }
}

package com.example.demo.controller;

import com.example.demo.db.Cafe;
import com.example.demo.db.Sentence;
import com.example.demo.dto.CafeAndSentDTO;
import com.example.demo.dto.CafeDto;
import com.example.demo.repository.CafeRepository;
import com.example.demo.service.CafeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CafeController {
    private CafeRepository cafeRepository;
    private CafeService cafeService;

    public CafeController(CafeRepository cafeRepository, CafeService cafeService) {
        this.cafeRepository = cafeRepository;
        this.cafeService = cafeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<CafeDto> cafeDtoList = cafeService.getCafeList();
        model.addAttribute("cafeList",cafeDtoList);
        return "home.html";
    }

//    /* 세부정보화면*/
//    @RequestMapping("/")
//    public String cafeInfo(@RequestParam("id") String id, Model model){
//        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
//        //List<Cafe> cafeList = (List<Cafe>) cafeService.getCafe(Integer.parseInt(id));
//
//
//        model.addAttribute("cafe_dto", cafeDto);
//
//        return "detailPage";
//    }

//    @GetMapping("/home")
//    public String home(Model model)
//    {
//        List<CafeDto> cafeDtoList = cafeService.getCafeList();
//        model.addAttribute("cafeList",cafeDtoList);
//        return "home.html";
//    }

}
package com.example.demo.controller;

import com.example.demo.db.Sentence;
import com.example.demo.dto.CafeAndSentDTO;
import com.example.demo.dto.SentenceDto;
import com.example.demo.service.CafeService;
import com.example.demo.dto.CafeDto;
import com.example.demo.service.SentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private CafeService cafeService;
    private SentService sentService;

    public HomeController(CafeService cafeService, SentService sentService){
        this.cafeService = cafeService;
        this.sentService = sentService;
    }

    /* 지도화면 */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /* 세부정보화면*/
    @RequestMapping("/more")
    public String cafeInfo(@RequestParam("id") String id, Model model){
        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
        List<Sentence> sentList = sentService.getSentence(Integer.parseInt(id));

        CafeAndSentDTO cafeAndSentDTO = new CafeAndSentDTO(cafeDto, sentList);
        model.addAttribute("dto", cafeAndSentDTO);
//        List<Sentence> sentences = sentService.getSentence(Integer.parseInt(id));
//        model.addAttribute("sentList", sentences);
//
//        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
//        model.addAttribute("dto", cafeDto);
        return "detailPage";
    }
}

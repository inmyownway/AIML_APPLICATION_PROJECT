package com.example.demo.controller;

import com.example.demo.db.Sentence;
import com.example.demo.dto.CafeAndSentDTO;
import com.example.demo.service.CafeService;
import com.example.demo.dto.CafeDto;
import com.example.demo.service.SentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String home(Model model) {
        List<CafeDto> cafeDtoList = cafeService.getCafelist();
        model.addAttribute("cafeList", cafeDtoList);
        return "home";
    }

    /* 세부정보화면*/
    @RequestMapping("/more")
    public String cafeInfo(@RequestParam("id") String id, Model model){
        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
        List<Sentence> sentList = sentService.getSentence(Integer.parseInt(id));

        CafeAndSentDTO cafeAndSentDTO = new CafeAndSentDTO(cafeDto, sentList);
        model.addAttribute("dto", cafeAndSentDTO);

        return "detailPage";
    }
    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/search/result")
    public String search(@RequestParam(value = "text", defaultValue = "") String text,
                         @RequestParam(value = "filters", defaultValue = "111111") String filter, Model model){
        //필터 선택안하면 111111으로 처리
        //하면 한것만 1인것들 검색
        model.addAttribute("searchResult",  cafeService.getSearchList(text));
        return "searchList";
    }
}


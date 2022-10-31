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
    public String search(@RequestParam("text") String text, @RequestParam("filter_val") String filter, Model model){
        //text = "스타벅스"
        //filter = "1"
        //filter 선택 안돼있으면 1,2,3,4,5,6으로
        //model.addAttribute("searchList",  cafeService.searchCafes(text, 필터는 어케하징));
        return "searchList";
    }
}


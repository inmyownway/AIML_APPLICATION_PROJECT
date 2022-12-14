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
    public String home(@RequestParam(value = "id", required = false) String id, Model model) {
        if(id==null){
            System.out.println("넘어온id없음");
            id = "0";
        }
        List<CafeDto> cafeDtoList = cafeService.getCafelist();
        model.addAttribute("cafeList", cafeDtoList);//db에서 가져온 카페들 정보 리스트
        model.addAttribute("idFromDetail",id);//넘어온 카페 id값 전달 (없으면 0)
        return "home";
    }

    /* 세부정보화면*/
    @RequestMapping("/more")
    public String cafeInfo(@RequestParam("id") String id, Model model){
        // id값(cafe_id)으로 해당 카페를 찾고 카페정보를 가져온다
        CafeDto cafeDto = cafeService.getCafe(Integer.parseInt(id));
        List<Sentence> sentList = sentService.getSentence(Integer.parseInt(id));
        // id값(cafe_id)으로 해당 카페를 찾고 문장을 가져온다
        CafeAndSentDTO cafeAndSentDTO = new CafeAndSentDTO(cafeDto, sentList);
        model.addAttribute("dto", cafeAndSentDTO);

        return "detailPage";
    }
    /* 검색화면 */
    @GetMapping("/search")
    public String search(){
        return "search";
    }

    /* 검색결과화면 */
    @GetMapping("/search/result")
    public String search(@RequestParam(value = "text", defaultValue = "") String text,
                         @RequestParam(value = "filters", defaultValue = "000000") String filter, Model model){
        //검색어: 기본값 null
        //필터: 선택 안 하면 000000으로 처리
        //하면 선택된 키워드들만 1인 것들 검색
        model.addAttribute("searchResult",  cafeService.getSearchList(text, filter));
        model.addAttribute("searchText", text);
        model.addAttribute("searchFilter", cafeService.getSearchFilterList(filter));
        return "searchList";
    }
}


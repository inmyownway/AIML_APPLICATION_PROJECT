package com.example.demo.controller;

import com.example.demo.object.Cafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    //지도화면
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //세부정보화면
    @RequestMapping(value = "/more", method=RequestMethod.GET)
    public String showMore(@RequestParam("id") String id, Model model) throws Exception {
        model.addAttribute("cafe_id", id);
        return "detailPage";
    }
    //검색창

}

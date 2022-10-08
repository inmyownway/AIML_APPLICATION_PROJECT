package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

public class homeController {
    @RequestMapping(value = "/naverMap")
    public String naverMap() {

        return "naverMap";
    }

}

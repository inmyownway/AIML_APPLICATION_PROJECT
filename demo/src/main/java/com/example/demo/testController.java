package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testController {

    @GetMapping("/")
    public String test(Model model)
    {
        Post post1 = new Post(1,"스타벅스 홍대역8번구점","b");
        Post post2 = new Post(1,"엔젤리너스 L7홍대점","c");
        Post post3 = new Post(1,"aaaaa","d");

        List<Post> list = new ArrayList<>();

        list.add(post1);
        list.add(post2);
        list.add(post3);
        model.addAttribute("list",list);
        return "index";

    }
}

package com.example.yazlab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/add-news")
    public String addNews() {
        return "add-news"; //view
    }





}

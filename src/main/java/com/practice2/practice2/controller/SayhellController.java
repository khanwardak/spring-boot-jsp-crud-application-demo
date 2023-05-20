package com.practice2.practice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class SayhellController {
    @RequestMapping("say-hello")
    public String view(){
        return "index";
    }
}


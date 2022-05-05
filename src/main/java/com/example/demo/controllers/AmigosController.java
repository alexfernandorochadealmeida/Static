package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AmigosController {
    
    @PostMapping("/novoAmigo")
    public String adicionarNovoAmigo() {
        return "";
    }

}

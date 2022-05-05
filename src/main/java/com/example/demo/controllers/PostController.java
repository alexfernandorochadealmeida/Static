package com.example.demo.controllers;

import com.example.demo.dto.PostDTO;
import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postagem")
public class PostController {
    
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/nova")
    public String novaPostagem(PostDTO postDTO) {
        try {
            Post novaPostagem = postDTO.toPost();
            postRepository.save(novaPostagem);
            return "redirect:/postagem/listar";
        } catch (IllegalArgumentException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/listar")
    public String minhasPostagens() {
        return "posts/listar";
    }

}

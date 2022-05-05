package com.example.demo.dto;

import com.example.demo.models.Post;

public class PostDTO {
    private String conteudo;


    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Post toPost() {
        if(conteudo.isEmpty()) throw new IllegalArgumentException("Campo \"Conteúdo\" vazio.");
        Post postagem = new Post();
        postagem.setConteudo(conteudo);
        return postagem;
    }


}

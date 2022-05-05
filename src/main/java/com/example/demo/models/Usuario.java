package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String senha;

    @ManyToMany
    @JoinTable(
        name = "amigos", 
        joinColumns = @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = true),
        inverseJoinColumns = @JoinColumn(name = "amigo", referencedColumnName = "id", nullable = true)
    )
    private List<Usuario> amigos;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Post> postagens;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL)
    private List<Grupo> meusGrupos;

    @ManyToMany(mappedBy = "membros", cascade = CascadeType.ALL)
    private List<Grupo> grupos;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Post> getPostagens() {
        return this.postagens;
    }

    public void setPostagens(List<Post> postagens) {
        this.postagens = postagens;
    }

    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Grupo> getMeusGrupos() {
        return this.meusGrupos;
    }

    public void setMeusGrupos(List<Grupo> meusGrupos) {
        this.meusGrupos = meusGrupos;
    }

    public List<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }


}

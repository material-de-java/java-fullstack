package com.cursojava.curso.Controllers;

import com.cursojava.curso.Models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario us = new Usuario(id, "Pedro", "Picasso", "pedro@picasso.net", "abc123");
        return us;
    }

    @RequestMapping(value = "usuario0")
    public Usuario editUsuario(){
        Usuario us = new Usuario();
        return us;
    }

    @RequestMapping(value = "usuario1")
    public Usuario deleteUsuario(){
        Usuario us = new Usuario();
        return us;
    }

    @RequestMapping(value = "usuario2")
    public Usuario findUsuario(){
        Usuario us = new Usuario();
        return us;
    }

}
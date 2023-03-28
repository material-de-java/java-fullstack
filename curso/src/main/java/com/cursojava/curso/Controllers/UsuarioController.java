package com.cursojava.curso.Controllers;

import com.cursojava.curso.Models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario us = new Usuario(id, "Pedro", "Picasso", "pedro@picasso.net", "abc123");
        return us;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getListaUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();
        Usuario us1 = new Usuario(111, "Pedro", "Picasso", "pedro@correo.net", "abc123");
        Usuario us2 = new Usuario(222, "Pablo", "Moreno", "pablo@correo.net", "abc456");
        Usuario us3 = new Usuario(333, "Victor", "Sierra", "victor@correo.net", "abc789");

        usuarios.add(us1);
        usuarios.add(us2);
        usuarios.add(us3);

        return usuarios;
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
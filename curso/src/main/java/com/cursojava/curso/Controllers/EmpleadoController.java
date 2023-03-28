package com.cursojava.curso.Controllers;

import com.cursojava.curso.DAO.EmpleadoDAO;
import com.cursojava.curso.Models.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {

    //esta notacion crea un objeto almacena automaticamente, este objeto es compartido en memoria
    @Autowired
    private EmpleadoDAO usuarioDAO;

    @RequestMapping(value = "usuario/{id}")
    public Empleado getUsuario(@PathVariable int id){
        Empleado us = new Empleado(id, "Pedro", "Picasso", 6177L, "pedro@picasso.net", "abc123");
        return us;
    }

    @RequestMapping(value = "usuarios")
    public List<Empleado> getListaUsuarios(){


        List<Empleado> us = usuarioDAO.getListaUsuarios();
        /*
        List<Usuario> usuarios = new ArrayList<>();
        Usuario us1 = new Usuario(111, "Pedro", "Picasso", 6166L,"pedro@correo.net", "abc123");
        Usuario us2 = new Usuario(222, "Pablo", "Moreno", 6155L, "pablo@correo.net", "abc456");
        Usuario us3 = new Usuario(333, "Victor", "Sierra", 6144L, "victor@correo.net", "abc789");

        usuarios.add(us1);
        usuarios.add(us2);
        usuarios.add(us3);
         */
        return us;
    }

    @RequestMapping(value = "usuario0")
    public Empleado editUsuario(){
        Empleado us = new Empleado();
        return us;
    }

    @RequestMapping(value = "usuario1")
    public Empleado deleteUsuario(){
        Empleado us = new Empleado();
        return us;
    }

    @RequestMapping(value = "usuario2")
    public Empleado findUsuario(){
        Empleado us = new Empleado();
        return us;
    }

}
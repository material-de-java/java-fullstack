package com.cursojava.curso.Controllers;

import com.cursojava.curso.DAO.EmpleadoDAO;
import com.cursojava.curso.Models.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {

    //esta notacion crea un objeto almacena automaticamente, este objeto es compartido en memoria
    @Autowired
    private EmpleadoDAO empleadoDAO;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Empleado getUsuario(@PathVariable int id){
        Empleado us = new Empleado(id, "Pedro", "Picasso", 6177L, "pedro@picasso.net", "abc123");
        return us;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Empleado> getListaUsuarios(){

        List<Empleado> us = empleadoDAO.getListaEmpleados();
        /*
        List<Usuario> Empleado = new ArrayList<>();
        Usuario us1 = new Empleado(111, "Pedro", "Picasso", 6166L,"pedro@correo.net", "abc123");
        Usuario us2 = new Empleado(222, "Pablo", "Moreno", 6155L, "pablo@correo.net", "abc456");
        Usuario us3 = new Empleado(333, "Victor", "Sierra", 6144L, "victor@correo.net", "abc789");

        us.add(us1);
        us.add(us2);
        us.add(us3);
         */
        return us;
    }

    @RequestMapping(value = "api/usuario0")
    public Empleado editUsuario(){
        Empleado us = new Empleado();
        return us;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable int id){
        empleadoDAO.deleteUsuario(id);
    }

    @RequestMapping(value = "api/usuario2")
    public Empleado findUsuario(){
        Empleado us = new Empleado();
        return us;
    }

}
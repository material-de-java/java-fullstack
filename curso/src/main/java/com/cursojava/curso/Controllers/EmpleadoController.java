package com.cursojava.curso.Controllers;

import com.cursojava.curso.DAO.EmpleadoDAO;
import com.cursojava.curso.Models.Empleado;
import com.cursojava.curso.utils.UtilsJWT;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    //esta notacion crea un objeto almacena automaticamente, este objeto es compartido en memoria
    // se crea una variable con el tipo de la interfaz
    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Autowired
    private UtilsJWT utilJWT;

    @RequestMapping(value = "api/empleados/{id}", method = RequestMethod.GET)
    public Empleado getEmpleado(@PathVariable int id){
        Empleado us = new Empleado(id, "Pedro", "Picasso", 6177L, "pedro@picasso.net", "abc123");
        return us;
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.GET)
    public List<Empleado> getListaUsuarios(@RequestHeader(value="Authorization") String token){

        if (validarToken(token)) {
            return null;
        }

        List<Empleado> us = empleadoDAO.getListaEmpleados();
        /*
        List<Usuario> Empleado = new ArrayList<>();
        Empleado us1 = new Empleado(111, "Pedro", "Picasso", 6166L,"pedro@correo.net", "abc123");
        Empleado us2 = new Empleado(222, "Pablo", "Moreno", 6155L, "pablo@correo.net", "abc456");
        Empleado us3 = new Empleado(333, "Victor", "Sierra", 6144L, "victor@correo.net", "abc789");

        us.add(us1);
        us.add(us2);
        us.add(us3);
         */
        return us;
    }

    @RequestMapping(value = "api/empleados", method = RequestMethod.POST)
    public void addEmpleado(@RequestBody Empleado emp){

        Argon2 arg2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        // se toma el passw, se convierte a char[] y luego se genera para guardarlo en el objeto
        // el hash asegura almacenar la passw en la bd de manera segura
        String hash = arg2.hash(6, 1024, 3, emp.getPassw().toCharArray());

        emp.setPassw(hash);
        empleadoDAO.addEmpleado(emp);
    }

    @RequestMapping(value = "api/usuario0")
    public Empleado editEmpleado(){
        Empleado us = new Empleado();
        return us;
    }

    @RequestMapping(value = "api/empleados/{id}", method = RequestMethod.DELETE)
    public void deleteEmpleado(@PathVariable int id, @RequestHeader(value="Authorization") String token){
        
        if (validarToken(token)) {
            return;
        }
        empleadoDAO.deleteEmpleado(id);
    }

    private boolean validarToken(String token){
        // se obtiene el id del empleado, se puede verificar que el id exista
        String empleadoId = utilJWT.getKey(token);
        return empleadoId!=null;
    }

}
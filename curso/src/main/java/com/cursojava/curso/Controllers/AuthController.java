package com.cursojava.curso.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.DAO.EmpleadoDAO;
import com.cursojava.curso.Models.Empleado;
import com.cursojava.curso.utils.UtilsJWT;

@RestController
public class AuthController {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Autowired
    private UtilsJWT ujwt;

    // empIncompleto solo tiene el correo y la passw, no contiene nada mas
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Empleado empIncompleto){
        
        String tokenJWT=null;
        // usando correo y passw se obtiene el empleado con todos los datos
        Empleado empLogin = empleadoDAO.obtenerEmpCredenciales(empIncompleto);
        
        // se uso cuando no estaba implemntado el token
        //result = empleadoDAO.verificarLogin(emp);

        if(empLogin!=null){
            tokenJWT = ujwt.create(String.valueOf(empLogin.getId()), empLogin.getCorreo());
        }

        // se pueden retornar muchas mas cosas,
        //ej. nivel de primilehios, permisos, informacion del empleado, etc

        return tokenJWT;
    }
    
}

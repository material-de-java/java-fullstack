package com.cursojava.curso.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.DAO.EmpleadoDAO;
import com.cursojava.curso.Models.Empleado;

@RestController
public class AuthController {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public boolean login(@RequestBody Empleado emp){
        boolean result = false;
        
        result = empleadoDAO.verificarLogin(emp);

        System.out.println("CONTROLLER AUTH: result="+result);

        return result;
    }
    
}

package com.cursojava.curso.DAO;

import java.util.List;

import com.cursojava.curso.Models.Empleado;

public interface EmpleadoDAO {

    List<Empleado> getListaEmpleados();

    void deleteEmpleado(int id);

    void addEmpleado(Empleado emp);

    boolean verificarLogin(Empleado emp);
    
}

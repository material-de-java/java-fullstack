package com.cursojava.curso.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursojava.curso.Models.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpleadoDAOImpl implements EmpleadoDAO{

    @PersistenceContext
    EntityManager entityMan;

    @Override
    @Transactional
    public List<Empleado> getListaEmpleados() {
        String consulta = "FROM Empleado"; //nombre de la clase
        List<Empleado> result = entityMan.createQuery(consulta).getResultList();
        return result;
    }

    @Override
    @Transactional
    public void deleteEmpleado(int id) {
        //busca el empleado por id. Luego lo elimina
        Empleado emp = entityMan.find(Empleado.class, id);
        entityMan.remove(emp);
    }

    @Override
    public void addEmpleado(Empleado emp) {
        //busca agrega el empleado a la BD
        entityMan.merge(emp);
    }
    
}

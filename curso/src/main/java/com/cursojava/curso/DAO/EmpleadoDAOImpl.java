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
    private EntityManager entityMan;

    @Override
    public List<Empleado> getListaUsuarios() {
        String consulta = "FROM templeados";
        List<Empleado> result = entityMan.createQuery(consulta).getResultList();
        return result;
    }
    
}

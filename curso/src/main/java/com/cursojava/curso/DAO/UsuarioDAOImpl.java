package com.cursojava.curso.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.Models.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO{

    @Override
    public List<Usuario> getUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarios'");
    }
    
}

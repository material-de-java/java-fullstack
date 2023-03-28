package com.cursojava.curso.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursojava.curso.Models.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO{

    @Override
    public List<Usuario> getUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarios'");
    }
    
}

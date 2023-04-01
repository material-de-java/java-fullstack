package com.cursojava.curso.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursojava.curso.Models.Empleado;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    @Transactional
    public void addEmpleado(Empleado emp) {
        //busca agrega el empleado a la BD
        entityMan.merge(emp);
    }

    @Override
    @Transactional
    public boolean verificarLogin(Empleado emp) {

        boolean result = false;

        // se consulta solo el correo y contraseña - esto es con hash
        // esta consulta FROM es igual a SELECT * FROM
        String consulta = "FROM Empleado WHERE correo= :correoIn";

        // se usa setParameter para evitar inyeccion de codigo
        List<Empleado> lista = entityMan.createQuery(consulta)
        .setParameter("correoIn", emp.getCorreo())
        .getResultList();

        // si la lista fuera vacia, daria nullpointerexception
        if(!lista.isEmpty()){
            // se saca el passw del emp que seria el passw con hash de la BD
            String passwHashed = lista.get(0).getPassw();

            Argon2 arg2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            // ahora se comparara el string de passw con el passHashed
            result = arg2.verify(passwHashed, emp.getPassw().toCharArray());

            System.out.println("CONTROLLER EMPL: rest="+result);
        }

        /*
        // se consulta el correo y contraseña - esto es sin hash
        String consulta = "FROM Empleado WHERE correo= :correoIn AND passw= :passwIn";

        // se usa setParameter para evitar inyeccion de codigo
        List<Empleado> lista = entityMan.createQuery(consulta)
        .setParameter("correoIn", emp.getCorreo())
        .setParameter("passwIn", emp.getPassw())
        .getResultList();

        // si la lista esta vacia es que no hay ninguna coincidencia
        return !lista.isEmpty();
         */

        return result;
    }

    @Override
    public Empleado obtenerEmpCredenciales(Empleado empIn) {

        Boolean result=false;
        Empleado empCompleto=null;

        String consulta = "FROM Empleado WHERE correo= :correoIn";

        // se usa setParameter para evitar inyeccion de codigo
        List<Empleado> lista = entityMan.createQuery(consulta)
        .setParameter("correoIn", empIn.getCorreo())
        .getResultList();

        // si la lista fuera vacia, daria nullpointerexception
        if(!lista.isEmpty()){
            empCompleto= lista.get(0);
            Argon2 arg2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            // ahora se comparara el string de passw con el pass del emp traido
            result = arg2.verify(empCompleto.getPassw(), empIn.getPassw().toCharArray());

            System.out.println("CONTROLLER EMPLCompleto: result= "+result+" -->");
            System.out.println(empCompleto.toString());

            if(!result){
                return null;
            }
        }
        return empCompleto;
    }
    
}

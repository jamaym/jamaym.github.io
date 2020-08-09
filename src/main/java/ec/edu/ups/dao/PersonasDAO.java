
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import java.util.List;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel Amay
 */

@Stateless
public class PersonasDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insertPersoa(Persona persona) throws Exception{
        
        
        
        em.persist(persona);
    }

    public Persona buscaPersona(String cedula) throws Exception{
        return em.find(Persona.class, cedula);
    }
    
    
    /*Recuperar Contactos*/
     /*Lista de Contactos*/
     public List<Persona>getPersonas(String filtro){
    String jpql="SELECT p FROM Persona p WHERE cedula LIKE :filtro";
    
        Query q=em.createQuery(jpql,Persona.class);
        q.setParameter("filtro", filtro +"%");
        return q.getResultList();
    }
    
    public void update(Persona p){
     em.merge(p);
    }
    
    
    
    }


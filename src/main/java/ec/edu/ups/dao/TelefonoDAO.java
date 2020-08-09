
package ec.edu.ups.dao;



import ec.edu.ups.modelo.Telefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Amay
 */


@Stateless
public class TelefonoDAO {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public void insertTelefono(Telefono telefono) throws Exception{
        em.persist(telefono);

    }

   public Telefono buscarTelefono(int id)throws Exception{
       return em.find(Telefono.class, id);
   }
    
    
    
}

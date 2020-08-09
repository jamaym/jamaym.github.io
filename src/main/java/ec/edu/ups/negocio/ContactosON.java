
package ec.edu.ups.negocio;

import ec.edu.ups.dao.PersonasDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author Daniel Amay
 */

@Stateless
public class ContactosON implements ContactosONLocal,ContactosONRemoto{
    
    @Inject
    private PersonasDAO daoPersona;
    
    @Inject
    private TelefonoDAO daoTelefono;
    
    /*    Persona   */
    public void guardaPersonaJPA(Persona persona) throws Exception{
        Persona aux =daoPersona.buscaPersona(persona.getCedula());
        
        if(aux!=null){
           daoPersona.update(persona);
        }
        else{
        if(validarCedula(persona.getCedula())==true){
            daoPersona.insertPersoa(persona);
        }
        }
    }
    
    public Persona buscarPersonaJPA(String cedula)throws Exception{
    return daoPersona.buscaPersona(cedula);
    }
    
    /* Telefono */
    public void guardaTelefonoJPA(Telefono telefono)throws Exception{
     daoTelefono.insertTelefono(telefono);
    }
    
    public Telefono buscarTelefonoJPA(int id)throws Exception{
    return daoTelefono.buscarTelefono(id);
    }
    
    
    public  List<Telefono> agregaNuevo(Telefono t) throws Exception{
        return agregaNuevo(new Telefono());
    }
    
    
    public boolean validarCedula(String cedula) throws Exception {
    boolean cedulaCorrecta = false;

    try {

        if (cedula.length() == 10) 
        {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
         
                int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                } else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                 
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } else {
            cedulaCorrecta = false;
        }
    } catch (NumberFormatException nfe) {
        cedulaCorrecta = false;
    } catch (Exception err) {
    	
    	
     
        cedulaCorrecta = false;
        throw new Exception("Una excepcion ocurrio en el proceso de validadcion"+err);
    }

    if (!cedulaCorrecta) {
    	throw new Exception("Cedula Incorrecta- !! Verifique la cedula para ingresar los contactos");
     
    }
    
    return cedulaCorrecta;

}

    
    public  List<Persona>recuperarPersonas()throws Exception{
    return daoPersona.getPersonas("%");
    }
    
  public  Persona getPersonas(String cedula)throws Exception{
    return daoPersona.buscaPersona(cedula);
    }
    
    
    
}

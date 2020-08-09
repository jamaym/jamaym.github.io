/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.negocio;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Daniel Amay
 */

@Remote
public interface ContactosONRemoto {
    
   /*    Persona   */
    public void guardaPersonaJPA(Persona persona) throws Exception;
    
    public Persona buscarPersonaJPA(String cedula)throws Exception;
    
    
    /* Telefono */
    public void guardaTelefonoJPA(Telefono telefono)throws Exception;
    
    public Telefono buscarTelefonoJPA(int id)throws Exception;

    //-----------------------------------------
     public List<Telefono> agregaNuevo(Telefono t) throws Exception;
    
      public boolean validarCedula(String cedula) throws Exception;
    
   public  List<Persona>recuperarPersonas()throws Exception;
   
    public  Persona getPersonas(String cedula)throws Exception;
      
}

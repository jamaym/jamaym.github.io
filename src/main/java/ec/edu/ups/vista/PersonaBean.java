/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosON;
import ec.edu.ups.negocio.ContactosONLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.SessionMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Daniel Amay
 */



@ManagedBean
@ViewScoped
public class PersonaBean {
    
  
    
    @Inject
    ContactosONLocal on;
    

    private Persona newPersona;
    private List<Persona>listado;

    
    private String cedula;
    private String titulo="Crear Personas";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        System.out.println("Cedula Parametro:" +cedula);
        this.cedula = cedula;
        if(cedula!=null){
            try {
                newPersona = on.getPersonas(cedula);
                titulo="Editar Persona " +cedula;
            } catch (Exception ex) {
                System.out.println("error"+ex);
            }
        }
    }
    
    
    
    public List<Persona> getListado() {
        return listado;
    }

    public void setListado(List<Persona> listado) {
        this.listado = listado;
    }
    
    
    
    
    
    @PostConstruct
    public void init(){
        newPersona=new Persona();
        newPersona.addTelefono(new Telefono());
       // loadDataPersonas();
        cargaPersonas();
    }

    public Persona getNewPersona() {
        return newPersona;
    }

    public void setNewPersona(Persona newPersona) {
        this.newPersona = newPersona;
    }

    @Override
    public String toString() {
        return "PersonaBean{" + "cedula=" + newPersona.getCedula()+ ", nombre=" + newPersona.getNombre() + ", listaTelofonos=" + newPersona.getTelefonos() + '}';
    }


     
    public String guardarDatos(){
    
        try {
          //  System.out.println(this.toString());
            on.guardaPersonaJPA(newPersona);
            System.out.println("Contacto Guardado");       
        } catch (Exception ex) {
            System.out.println("Error al Ingresar [PersonaBean]"+ex.getMessage());
        }
       return "lista";
    }
    
   
    public String AddTelefono(){
        newPersona.addTelefono(new Telefono());
        return null;
    }
    
 
    public void loadDataPersonas(){
        try {
    
            newPersona=on.buscarPersonaJPA(newPersona.getCedula());
            System.out.println("hhh"+newPersona.getCedula());
            
            
            
        } catch (Exception ex) {
            System.out.println("Error al Listar"+ex.getMessage());
        }
               
    }
    
     private void cargaPersonas(){
        try {
    
            listado=on.recuperarPersonas();
           
            List<Persona>l2=on.recuperarPersonas();
            
            for(Persona pl:l2){
                System.out.println("Cedula:"+pl.getCedula());
                System.out.println("Nombre:"+pl.getNombre());
                System.out.println("---"+pl.getTelefonos());
                
            }
            
            
            
        } catch (Exception ex) {
            System.out.println("Error al Listar"+ex.getMessage());
        }
               
    }
    
     public String editar(String cedula){
      /*  try {
            System.out.println(cedula);
            newPersona=on.getPersonas(cedula);
            return "CrearContacto";
        } catch (Exception ex) {
            System.out.println("Error al editar"+ex.getMessage());
        }*/
        
    return "CrearContacto?faces-redirect=true&cedula="+cedula;
     }
  
}

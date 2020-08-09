/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Daniel Amay 
 */



@Entity
public class Persona  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column(name="cedula")
    private String cedula;
    
    @Column(name="nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "persona",fetch = FetchType.EAGER)
    private List<Telefono> telefonos;

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + '}';
    }
    
    public void addTelefono (Telefono telefono){
        if(telefonos==null)
            telefonos=new ArrayList<>();
             this.telefonos.add(telefono);
       
    
    
    }
    
   
    
    
    
    
}

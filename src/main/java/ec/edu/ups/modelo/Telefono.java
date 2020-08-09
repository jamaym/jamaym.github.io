/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javafx.scene.text.Font;
import javax.enterprise.inject.New;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Daniel Amay
 */


@Entity
public class Telefono implements Serializable{
    
      private static final long serialVersionUID = 1L;
    
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column (name="id")
      private int id;
      
      @Column(name="numero")
      private String numero;
      
      @Column(name="tipoTelefono")
      private String tipoTelefono;
      
      @ManyToOne
      @JoinColumn(name="cedula")
      private Persona persona;

      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
    
   
    return   " [Numero: " +this.numero +"    Tipo Telefono:  " +this.tipoTelefono +"]--";

    
    }
      
      
      
      
      

      
      
    
    
}

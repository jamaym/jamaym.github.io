package ec.edu.ups.vista;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosON;
import ec.edu.ups.negocio.ContactosONLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel Amay
 */
@WebServlet("/persona")
public class VistaPersona extends HttpServlet {

    @Inject
    private ContactosONLocal on;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try {
            response.getWriter().println("<h1> Personas </h1>");
/*
      Persona p=new Persona();
            p.setCedula("0106540214");
            p.setNombre("Daniel Amay");
         
            
            
            Telefono t1=new Telefono();
            t1.setNumero("2816237");
            t1.setTipoTelefono("casa");
            t1.setPersona(p);
            
            
            Telefono t2=new Telefono();
            t2.setNumero("0969091013");
            t2.setTipoTelefono("Celular");
            t2.setPersona(p);
            
            List<Telefono>listaTelefonos=new ArrayList<>();
            listaTelefonos.add(t1);
            listaTelefonos.add(t2);
            
            p.setTelefonos(listaTelefonos);

            on.guardaPersonaJPA(p);
   */
    
          Persona buscar=on.buscarPersonaJPA("0106540214");
          //  response.getWriter().println("<h1> Nombre:</h1>"+buscar.getNombre());
         // response.getWriter().println("<h1> Cedula:</h1>"+buscar.getCedula());

          response.getWriter().println("<h1> Numeros:</h1>"+buscar.getTelefonos());
          
           
        } catch (Exception ex) {
            System.out.println("Error"+ex.getMessage());
       
         }
 
        
       
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
}

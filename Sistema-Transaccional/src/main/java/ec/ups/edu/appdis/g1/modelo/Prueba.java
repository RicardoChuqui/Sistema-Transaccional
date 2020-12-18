

package ec.ups.edu.appdis.g1.modelo;


import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.appdis.g1.negocio.GestionBancariaON;

/**
 *
 * @author Ricardo Chuqui
 */
@WebServlet("/prueba")
public class Prueba extends HttpServlet {

    @Inject
   private GestionBancariaON on;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.getWriter().println("Hola Mundo..");
        Cuenta c=new Cuenta();
        
        c.setIdCuenta("2816237");
        
        on.depositar("2816237", 3);
            response.getWriter().println("Deposito..");
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

}

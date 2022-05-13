package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;


@WebServlet(name = "Mostrar", urlPatterns = {"/mostrar.do"})
public class Mostrar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Persona p = new Persona(); // Conectar a la BD
        ArrayList<Persona> personas = new ArrayList();
        personas = p.consultarRegistros(); // Consulta los registros y los almacena en nuevo array llamado personas
        request.getSession().setAttribute("personas", personas); //Asignar valores a la sesion
        request.getRequestDispatcher("mostrartodo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

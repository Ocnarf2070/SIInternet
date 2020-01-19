/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franco Emanuel González Sánchez
 */
@WebServlet(name = "NIF", urlPatterns = {"/NIF"})
public class NIF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
	private  static final String LETRAS_NIF="TRWAGMYFPDXBNJZSQVHLCKE";
	private String calcularNIF(String dni){
        String res = "";
        if (dni!=null){
			try{
				int r;
				Integer d=new Integer(dni);
				if(d>=0&&d<=99999999){
					r=d%23;
					res = dni + LETRAS_NIF.charAt(r);
				}else res = "El numero no esta en el rango correcto.";
			}catch(NumberFormatException e){
				res = "Se debe escribir un número.";
			}
        }
        return res;
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NIF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NIF at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"post\" action=\"NIF\" >");
            out.println("DNI: ");
            out.println("<input type=\"text\" name=\"DNI\" value="+ (dni!=null?dni:"") + "><br>");            
            out.println("NIF: "+ calcularNIF(dni) +"<br>");
            out.println("<input type=\"submit\" value=\"Calcular\">");
            out.println("</form>"); 
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

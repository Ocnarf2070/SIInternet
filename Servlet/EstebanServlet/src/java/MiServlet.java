/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esteban
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hola Mundo</title>");            
            out.println("<meta charset=\"utf-8\"");            
            out.println("</head>");
            out.println("<body>");          
            out.println("<h1>Hola mundo! at " + request.getContextPath() + "</h1>");
            out.println("<p>Aleatorio: " + Math.random());
            out.print("<p><img src=\"./logoUMA.jpg\" alt=\"logo UMA\">");
            
            out.println("<p>getParameterMap: <br>");
            Map<String,String[]> params = request.getParameterMap();
            out.println("<ul>");
            for (Map.Entry<String,String[]> e : params.entrySet())
            {
                String k = e.getKey();
                for (String v : e.getValue())
                {
                    out.println("<li>"+k+"="+v+"</li>");
                }
            }
            out.println("</ul>");
            out.println("<p>getRequestURL: " + request.getRequestURL());
            out.println("<p>getRequestURI: " + request.getRequestURI());
            out.println("<p>getHeaders: <br>");
            Enumeration names = request.getHeaderNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println(name + ": " + value + "<br>");
                  }
                }
            }            
            out.println("<p>getCookies: <br>");
            String sessionid = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
              for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("sessionid")) {
                  sessionid = cookies[i].getValue();
                  break;
                }
              }
            }
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

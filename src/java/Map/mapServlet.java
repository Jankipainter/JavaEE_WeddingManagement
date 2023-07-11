/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Map;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
@WebServlet(name = "mapServlet", urlPatterns = {"/mapServlet"})
public class mapServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
           
            if (request.getParameter("addPlace") != null)
            {
                try(Connection connection = DbConnect.getConnection(); Statement stmt = connection.createStatement();) {
                    
                    if (connection != null)
                    {
                        String address;
                        
                        address = request.getParameter("address");
                        
                        String query = "INSERT INTO location(location_id,location_name) VALUES(NULL,?)";
                        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
                            
                            connection.setAutoCommit(false);
                            pstmt.setString(1, address);
                            
                            int n = pstmt.executeUpdate();
                            connection.commit();
                            response.sendRedirect("http://localhost:8080/RealWeddingProject/Map.jsp");
                            
                        } catch (SQLException e) {
                            
                            System.out.println("SQL exception: ");
                            connection.rollback();
                            e.printStackTrace();
                        }catch (Exception e) {
                            System.out.println("exception: ");
                            connection.rollback();
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        System.out.println("Connection not Established !!");
                    }
                    
                } catch (Exception e) {
                    
                    System.out.println("Exception : " + e);
                }
            }
            else
            {
                out.println("seems you lost in space, click <a href='http://localhost:8080/RealWeddingProject/User/Map.jsp'>here</a> to go home.");
            }
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

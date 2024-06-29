/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.SocmedDAO;
import Model.Socmed;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SocmedServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
    private SocmedDAO socmedDAO;

    public void init() {
        socmedDAO = new SocmedDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String description = request.getParameter("description");

        // Convert the date string to java.sql.Date
        Date log_date = Date.valueOf(date);

        Socmed socmed = new Socmed();
        socmed.setLog_date(log_date);
        socmed.setDescription(description);

        try {
            socmedDAO.insertSocmed(socmed);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Redirect to the marketing inventory page
        response.sendRedirect("Socmed.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "SocmedServlet";
    }
    

}
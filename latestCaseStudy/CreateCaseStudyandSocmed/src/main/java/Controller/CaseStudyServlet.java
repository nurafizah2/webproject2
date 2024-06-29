/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CaseStudyDAO;
import Model.CaseStudy;
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

/**
 *
 * @author USER
 */


public class CaseStudyServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
    private CaseStudyDAO caseStudyDAO;

    public void init() {
        caseStudyDAO = new CaseStudyDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String description = request.getParameter("description");

        // Convert the date string to java.sql.Date
        Date log_date = Date.valueOf(date);

        CaseStudy caseStudy = new CaseStudy();
        caseStudy.setLog_date(log_date);
        caseStudy.setDescription(description);

        try {
            caseStudyDAO.insertCaseStudy(caseStudy);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Redirect to the marketing inventory page
        response.sendRedirect("CaseStudy.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "CaseStudyServlet";
    }
    

}
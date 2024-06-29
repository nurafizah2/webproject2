package Controller;

import DAO.MarketingDAO;
import Model.Marketing;
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


public class MarketingServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
    private MarketingDAO marketingDAO;

    public void init() {
        marketingDAO = new MarketingDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String description = request.getParameter("description");

        // Convert the date string to java.sql.Date
        Date log_date = Date.valueOf(date);

        Marketing marketing = new Marketing();
        marketing.setLog_date(log_date);
        marketing.setDescription(description);

        try {
            marketingDAO.insertMarketing(marketing);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Redirect to the marketing inventory page
        response.sendRedirect("Marketing.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "MarketingServlet";
    }
    

}

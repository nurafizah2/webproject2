package Controller;
/**
 * @author Nurafizah
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import DAO.ClientDao;
import DAO.AdminDAO;
import Model.client;
import Model.admin;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        String username = request.getParameter("username");
        String password = request.getParameter("pw");
        String role = request.getParameter("role");

         if (username != null && password != null && role != null) {
            try {
                if (role.equals("client")) {
                    ClientDao clientDao = new ClientDao();
                    client client = new client();
                    client.setUsername(username);
                    client.setPassword(password);
                    client.setRole(role);
                    clientDao.insertClient(client);
                    response.getWriter().println("Registration successful for Client!");
                } else if (role.equals("admin")) {
                    AdminDAO adminDao = new AdminDAO();
                    admin admin = new admin();
                    admin.setUsername(username);
                    admin.setPassword(password);
                    admin.setRole(role);
                    adminDao.insertAdmin(admin);
                    response.getWriter().println("Registration successful for Admin!");
                }
                response.sendRedirect("login.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Please fill out all fields.");
        }
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
     
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


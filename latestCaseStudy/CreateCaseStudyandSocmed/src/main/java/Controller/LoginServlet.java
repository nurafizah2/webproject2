package Controller;
/**
 * @author Nurafizah
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import DAO.AdminDAO;
import DAO.ClientDao;
import Model.admin;
import Model.client;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pw");
        String role = request.getParameter("role");

 boolean isValidUser = false;

        try {
            if ("admin".equals(role)) {
                AdminDAO adminDao = new AdminDAO();
                admin admin = adminDao.getAdminByUsernameAndPassword(username, password);
                if (admin != null) {
                    isValidUser = true;
                }
            } else if ("client".equals(role)) {
                ClientDao clientDao = new ClientDao();
                client client = clientDao.getClientByUsernameAndPassword(username, password);
                if (client != null) {
                    isValidUser = true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (isValidUser) {
            if ("admin".equals(role)) {
                response.sendRedirect("Marketing.jsp");
            } else {
                response.sendRedirect("clientHomepage.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "User not found. Please register.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the login form
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Handles user login";
    }
}

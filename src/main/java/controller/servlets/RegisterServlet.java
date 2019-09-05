package controller.servlets;

import service.Service;
import util.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Service registerService;

    public void init() {
        registerService = new Service();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            execute(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            execute(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int status;
        String login = request.getParameter("username");
        String password = request.getParameter("userpass");
        if (Validator.isCorrectLogin(login) && Validator.isCorrectPassword(password))
        {
            status = registerService.registerUser(login,
                password, request.getParameter("firstName"), request.getParameter("lastName"));
            if (status >= 0) {
                response.sendRedirect("/login");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Smth went wrong.</font>");
                rd.include(request, response);
            }
        }
        else response.sendRedirect("/login");

    }
}

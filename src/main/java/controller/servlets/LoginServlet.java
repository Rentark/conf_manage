package controller.servlets;

import model.entity.User;
import service.LoginService;
import service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet({"/login", ""})
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    public void init() {
        loginService = LoginService.getInstance();
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

        // get request parameters for userID and password
        String login = request.getParameter("username");
        String pass = request.getParameter("userpass");
        User userObj = loginService.validateUser(login, pass);
        if(userObj != null){
            HttpSession session = request.getSession();
            session.setAttribute("userSession", userObj);
//            request.setAttribute("userObj", userObj);
//            session.setMaxInactiveInterval(30*60);
//            Cookie userName = new Cookie("userCookie", login);
//            userName.setMaxAge(30*60);
//            response.addCookie(userName);
//            request.setAttribute("meetings", loginService.getMeetingsList());
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/meetings");
//            rd.forward(request, response);
            response.sendRedirect("/meetings");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        }
//        try {
//            boolean isOk = service.validateUser(request.getParameter("username"), request.getParameter("userpass"));
//            request.setAttribute("user", isOk);
//            RequestDispatcher view = request.getRequestDispatcher("main.jsp");
//            view.forward(request, response);
//        } catch (SQLException | ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
}

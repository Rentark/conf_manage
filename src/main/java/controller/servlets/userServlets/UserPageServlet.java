package controller.servlets.userServlets;

import controller.commands.CommandMap;
import service.ReportsService;
import service.UsersService;
import util.PathFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/*")
public class UserPageServlet extends HttpServlet {

//    public void doPost(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            execute(request, response);
//        } catch (IOException | ServletException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            execute(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPageItemPath = request.getRequestURI();
        request.getSession().setAttribute("UserPageItemPathSession", userPageItemPath);

//        String path = (request.getPathInfo() == null ? "/user" : "/user/" + request.getPathInfo());

        String page = CommandMap.getCommand(PathFinder.findPath(request.getRequestURI())).execute(request);
        if (page.endsWith(".jsp")) {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        }
        else {
//                response.setHeader("Pragma", "No-cache");
//                response.setHeader("Cache-Control", "no-cache");
//                response.setDateHeader("Expires", -2);
            response.sendRedirect(page);
        }
    }
}

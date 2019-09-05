package controller.servlets.userServlets;

import controller.commands.CommandMap;
import util.PathFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editUserInfo", urlPatterns = {"/editUserInfo", "/user/editUserInfo"})
public class UserDataEditServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
//        String path = (request.getPathInfo() == null ? "/editUserInfo" : "/editUserInfo" + request.getPathInfo());

        String page = CommandMap.getCommand(PathFinder.findPath(request.getRequestURI())).execute(request);
        if (page.endsWith(".jsp")) {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }
}

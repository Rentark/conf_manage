package controller.servlets.reportServlets;

import controller.commands.CommandMap;
import util.PathFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reportUserActivity", urlPatterns = {"/reportUserActivity", "/meetings/meeting/reportUserActivity"})
public class ReportUserActivityServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String path = request.getParameter("btnAction");

        String page = CommandMap.getCommand(PathFinder.findPath(path)).execute(request);
//        if (page.endsWith(".jsp")) {
//            getServletContext().getRequestDispatcher(page).forward(request, response);
//        }
//        else {
            response.sendRedirect(page);
//        }
    }
}

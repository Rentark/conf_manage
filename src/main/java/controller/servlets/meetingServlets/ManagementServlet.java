package controller.servlets.meetingServlets;

import controller.commands.CommandMap;
import service.MeetingsService;
import service.ReportsService;
import service.UsersService;
import util.PathFinder;
import util.PathFinderDepr;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "management", urlPatterns = {"/management/*", "/management/meetings", "/management/meetingManagement", "/meetingManagement", "/management/reportManagement", "/reportManagement"})
public class ManagementServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("servletName", getServletName());
        String page = CommandMap.getCommand(PathFinder.findPath(PathFinder.selectAction(request, request.getRequestURI()))).execute(request);

//        String page = CommandMap.getCommand(PathFinder.findPath(request.getAttribute("btnAction").toString())).execute(request, response);
        if (page.endsWith(".jsp")) {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        }
        else {
            response.sendRedirect(page);
        }
    }
}

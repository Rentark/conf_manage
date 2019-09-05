package controller.servlets.meetingServlets;

import controller.commands.CommandMap;
import util.PathFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//"/reportUserActivity"
@WebServlet(name = "meeting", urlPatterns = {"/meetings", "/meetings/meeting/*"})
    public class MeetingShowServlet extends HttpServlet {
//        private MeetingsService meetingsService;
//        private UsersService usersService;
//        private ReportsService reportsService;
//
//        public void init() {
//            meetingsService = MeetingsService.getInstance();
//            usersService = UsersService.getInstance();
//            reportsService = ReportsService.getInstance();
//        }

//        public void doPost(HttpServletRequest request, HttpServletResponse response) {
//            try {
//                execute(request, response);
//            } catch (IOException | ServletException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void doGet(HttpServletRequest request, HttpServletResponse response) {
//            try {
//                execute(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }

        public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getSession().setAttribute("servletName", getServletName());

            String page = CommandMap.getCommand(PathFinder.findPath(request.getRequestURI())).execute(request);
            if (page.endsWith(".jsp")) {
                getServletContext().getRequestDispatcher(page).forward(request, response);
            }
            else {
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 1);
                response.sendRedirect(page);
            }
        }
}

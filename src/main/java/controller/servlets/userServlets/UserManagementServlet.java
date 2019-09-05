package controller.servlets.userServlets;

import model.entity.Roles;
import model.entity.User;
import service.UsersService;
import util.PathFinderDepr;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/users")
public class UserManagementServlet extends HttpServlet {
    private UsersService usersService;

    public void init() {
        usersService = UsersService.getInstance();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            execute(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            execute(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID;
        String path = request.getPathInfo();
        String userManageItemPath = request.getRequestURI();
        HttpSession session = request.getSession();
        List<Roles> rolesList = Arrays.asList(Roles.values());
        List<User> usersList = usersService.getAll();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("meetings.jsp");
        //String z = rolesList.stream().filter(x -> path.matches(x.getRegex())).findAny().get().getValue;

        switch (PathFinderDepr.findPath(request.getRequestURI())) {
            default:
            case "servlet" :
                request.setAttribute("rolesList", rolesList);
                request.setAttribute("usersList", usersList);
                rd.include(request, response);
                break;
            case "roleChange" :
                userID = Integer.parseInt(request.getParameter("userID"));
                String newRole = request.getParameter("role");
                User userToSetRole = usersList.stream().filter(x -> x.getUserID() == userID).findAny().get();
                usersService.updateUserRole(userToSetRole, Roles.valueOf(newRole).getRole());
                usersList = usersService.getAll();
                request.setAttribute("usersList", usersList);
                rd.include(request, response);
                break;
            case "deleteUser" :
                userID = Integer.parseInt(request.getParameter("userID"));
                User userDelete = usersList.stream().filter(x -> x.getUserID() == userID).findAny().get();
                usersService.deleteUser(userDelete);
                usersList = usersService.getAll();
                request.setAttribute("usersList", usersList);
                rd.include(request, response);
                break;
        }
    }
}

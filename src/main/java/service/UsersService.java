package service;

import com.sun.deploy.net.HttpRequest;
import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.UsersDAOMySql;
import model.entity.User;
import model.entity.UserActivity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UsersService {
    private UsersDAOMySql usersDAOMySql = AbstractDAOFactory.getInstance().createUsersDAO(Connector.getConnection());
    private static UsersService instance;

    private UsersService() {
    }

    public static synchronized UsersService getInstance() {
        if (instance == null) {
            instance = new UsersService();
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    public List<User> getAll() {
        return usersDAOMySql.getAll();
    }

    public User getUserByID(int id) {
        return usersDAOMySql.getItemByID(id);
    }

    public int deleteUser(User user) {
        return usersDAOMySql.delete(user);
    }

    public User createNewUserActivity(HttpServletRequest request, User user) {
        UserActivity userActivity = new UserActivity.Builder()
                .setReportRegistered(Integer.parseInt(request.getParameter("reportID")))
                .setUser_id(user.getUserID())
                .setReportAttendance(false)
                .build();
        return usersDAOMySql.insertUserActivity(userActivity);
    }
// save allusers to list/map/wtvr to not get to work with db all the time?
    public User setAttendedActivity(HttpServletRequest request, User user, boolean status) {
        int reportID = (Integer) request.getAttribute("reportID");
        UserActivity userActivity = user.getUserActivity().stream().filter(x -> x.getReportRegistered() == reportID).findAny().get();
        userActivity.setReportAttendance(status);
        return usersDAOMySql.updateUserActivity(userActivity);
    }

    public User removeUserActivity(HttpServletRequest request, User user) {
        int reportIDtoDel = Integer.parseInt(request.getParameter("reportID"));
        UserActivity userActivity = user.getUserActivity().stream().filter(x -> x.getReportRegistered() == reportIDtoDel).findAny().get();
        return usersDAOMySql.deleteUserActivity(userActivity);
    }

    public User updateUser(HttpServletRequest request, User user) {
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPassword(request.getParameter("password"));
        usersDAOMySql.update(user);
        return usersDAOMySql.getItemByID(user.getUserID());
    }

    public User updateUserRole(User user, String role) {
        user.setRole(role);
        usersDAOMySql.update(user);
        return usersDAOMySql.getItemByID(user.getUserID());
    }
}

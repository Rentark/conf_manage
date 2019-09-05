package controller.commands.userCommands;

import controller.commands.Command;
import model.entity.User;
import service.ReportsService;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ShowAnyUserInfo implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = UsersService.getInstance().getUserByID(Integer.parseInt(request.getParameter("userID")));

        request.getSession().setAttribute("UserPageItemPathSession", request.getRequestURI());
        request.setAttribute("userInfo", user);
        request.setAttribute("reportsListForUser",
                ReportsService.getInstance()
                        .getReportsForUser(user));
        return "user.jsp";
    }
}

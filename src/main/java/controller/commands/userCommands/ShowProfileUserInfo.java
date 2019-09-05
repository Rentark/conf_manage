package controller.commands.userCommands;

import controller.commands.Command;
import model.entity.User;
import service.ReportsService;

import javax.servlet.http.HttpServletRequest;

public class ShowProfileUserInfo implements Command {

    public ShowProfileUserInfo() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("UserPageItemPathSession", request.getRequestURI());

        request.setAttribute("reportsListForUser",
                ReportsService.getInstance()
                        .getReportsForUser((User) request.getSession().getAttribute("userSession")));
        return "user.jsp";
    }
}

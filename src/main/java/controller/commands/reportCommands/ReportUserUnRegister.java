package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.User;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ReportUserUnRegister implements Command {
    public ReportUserUnRegister() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("userSession",
                UsersService.getInstance()
                        .removeUserActivity(request, (User) request.getSession().getAttribute("userSession")));

        return request.getSession().getAttribute("meetingItemPathSession").toString();
    }
}

package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.User;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ReportUserRegister implements Command {

    public ReportUserRegister() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("userSession",
                    UsersService.getInstance()
                            .createNewUserActivity(request, (User) request.getSession().getAttribute("userSession")));

        return request.getSession().getAttribute("meetingItemPathSession").toString();
    }
}

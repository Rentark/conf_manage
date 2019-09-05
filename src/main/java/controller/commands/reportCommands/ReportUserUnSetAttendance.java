package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.User;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ReportUserUnSetAttendance implements Command {

    @Override
    public String execute(HttpServletRequest request) {
                UsersService.getInstance()
                        .setAttendedActivity(request,
                                UsersService.getInstance().getUserByID(Integer.parseInt(request.getParameter("userID"))), false);
        return request.getSession().getAttribute("meetingItemPathSession").toString();
    }
}

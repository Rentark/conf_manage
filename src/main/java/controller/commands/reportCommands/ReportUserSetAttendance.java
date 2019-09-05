package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.User;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ReportUserSetAttendance implements Command {

    public ReportUserSetAttendance() {
    }

    @Override
    public String execute(HttpServletRequest request) {

                    UsersService.getInstance()
                            .setAttendedActivity(request,
                                    UsersService.getInstance().getUserByID(Integer.parseInt(request.getParameter("userID"))), true);

        return request.getSession().getAttribute("meetingItemPathSession").toString();
    }

}

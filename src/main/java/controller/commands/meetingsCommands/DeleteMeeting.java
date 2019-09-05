package controller.commands.meetingsCommands;

import controller.commands.Command;
import service.MeetingsService;

import javax.servlet.http.HttpServletRequest;

public class DeleteMeeting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        MeetingsService.getInstance().deleteMeeting(Integer.parseInt(request.getParameter("meetingID")));
        return "/meetings";
    }
}

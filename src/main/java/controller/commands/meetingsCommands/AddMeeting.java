package controller.commands.meetingsCommands;

import controller.commands.Command;
import service.MeetingsService;

import javax.servlet.http.HttpServletRequest;

public class AddMeeting implements Command {
    @Override
    public String execute(HttpServletRequest request) {

//        probly move instance creation from service to here
        MeetingsService.getInstance().addNewMeeting(request, request.getSession());

        return request.getSession().getAttribute("meetingItemPath").toString();
    }
}

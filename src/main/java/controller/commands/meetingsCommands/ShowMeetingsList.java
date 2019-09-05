package controller.commands.meetingsCommands;

import controller.commands.Command;
import service.MeetingsService;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class ShowMeetingsList implements Command {

    public ShowMeetingsList() {
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("meetingsList", MeetingsService.getInstance().getMeetings());
        request.getSession().setAttribute("usersList", UsersService.getInstance().getAll());
        return selectOutput(request.getSession().getAttribute("servletName").toString());
    }

    private String selectOutput(String servletName) {
        switch (servletName) {
            case "meeting" :
                return "/WEB-INF/meetings.jsp";
            case "management" :
                return "/WEB-INF/meetingsManagement.jsp";
        }
        return null;
    }
}

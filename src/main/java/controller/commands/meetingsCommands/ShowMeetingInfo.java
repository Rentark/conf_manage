package controller.commands.meetingsCommands;

import controller.commands.Command;
import service.MeetingsService;
import service.ReportsService;

import javax.servlet.http.HttpServletRequest;

public class ShowMeetingInfo implements Command {

    public ShowMeetingInfo() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        String meetingItemPath = request.getRequestURI();
        request.getSession().setAttribute("meetingItemPathSession", meetingItemPath);
        int meetingId = Integer.parseInt(meetingItemPath.substring(meetingItemPath.lastIndexOf('/') + 1));
        request.setAttribute("meetingItemInfo", MeetingsService.getInstance().getMeetingInfo(meetingId));
        request.setAttribute("reportsListForMeeting", ReportsService.getInstance().getReportsForMeeting(meetingId));
        return selectOutput(request.getSession().getAttribute("servletName").toString());
    }

    private String selectOutput(String servletName) {
        switch (servletName) {
            case "meeting" :
                return "/WEB-INF/meeting.jsp";
            case "management" :
                return "/WEB-INF/meetingEdit.jsp";
        }
        return null;
    }
}

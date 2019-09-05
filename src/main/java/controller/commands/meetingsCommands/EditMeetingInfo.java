package controller.commands.meetingsCommands;

import controller.commands.Command;
import model.entity.Meeting;
import model.entity.User;
import model.entity.Venue;
import service.MeetingsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditMeetingInfo implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            MeetingsService.getInstance().editMeeting(new Meeting.MeetingBuilder()
                    .setMeetingID(Integer.parseInt(request.getParameter("meetingID")))
                    .setName(request.getParameter("meetingName"))
                    .setOrganizerID(((User) request.getSession().getAttribute("userSession")).getUserID())
                    .setTime((Date) simpleDateFormat.parse(request.getParameter("meetingTime")))
                    .setEndTime((Date) simpleDateFormat.parse(request.getParameter("meetingEndTime")))
                    .setVenue(new Venue.Builder()
                            .setVenueID(Integer.parseInt(request.getParameter("venueID")))
                            .setStreet(request.getParameter("street"))
                            .setRoom(request.getParameter("room"))
                            .setHouse(request.getParameter("house"))
                            .setCity(request.getParameter("city"))
                            .build())
                    .build());
        } catch (ParseException e) {
            //loggit
        }

        return request.getSession().getAttribute("meetingItemPathSession").toString();
    }
}

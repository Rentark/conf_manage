package service;

import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.MeetingsDAOMySql;
import model.entity.Meeting;
import model.entity.User;
import model.entity.Venue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MeetingsService {
    private MeetingsDAOMySql meetingsDAOMySql = AbstractDAOFactory.getInstance().createMeetingsDAO(Connector.getConnection());;
    private static MeetingsService instance;

    private MeetingsService() {
    }

    public static synchronized MeetingsService getInstance() {
        if (instance == null) {
            instance = new MeetingsService();
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    public List<Meeting> getMeetings() {
        return meetingsDAOMySql.getAll();
    }

    public Meeting getMeetingInfo(int id) {
        Meeting meeting = meetingsDAOMySql.getAll().stream().filter(x -> x.getMeetingID() == id).findAny().get();
        System.out.println("\n" + meeting.getVenue().getVenueID());
        return meeting;
    }

    public int addNewMeeting(HttpServletRequest request, HttpSession session) {
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        User user = (User) session.getAttribute("userSession");
        Meeting meeting = null;
        try {
            meeting = new Meeting.MeetingBuilder()
                    .setName(request.getParameter("meetingName"))
                    .setOrganizerID(user.getUserID())
                    .setTime((Date) simpleDateFormat.parse(request.getParameter("meetingStartDate") + request.getParameter("meetingStartTime")))
                    .setEndTime((Date) simpleDateFormat.parse(request.getParameter("meetingEndDate") + request.getParameter("meetingEndTime")))
                    .setVenue(new Venue.Builder()
                            .setStreet(request.getParameter("street"))
                            .setRoom(request.getParameter("room"))
                            .setHouse(request.getParameter("house"))
                            .setCity(request.getParameter("city"))
                            .build())
                    .build();
        } catch (ParseException e) {
            //loggit
        }
        return meetingsDAOMySql.insert(meeting);
    }

    public int editMeeting(Meeting meeting) {
        return meetingsDAOMySql.update(meeting);
    }

    public int deleteMeeting(int id) {
        return meetingsDAOMySql.delete(meetingsDAOMySql.getItemByID(id));
    }
}

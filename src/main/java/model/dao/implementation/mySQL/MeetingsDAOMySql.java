package model.dao.implementation.mySQL;

import model.dao.BaseQueriesIF;
import model.dao.DaoIF;
import model.dao.factory.AbstractDAOFactory;
import model.entity.Entity;
import model.entity.Meeting;
import model.entity.Venue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MeetingsDAOMySql extends AbstractDAO implements BaseQueriesIF, DaoIF {
    private static VenuesDAOMySql venuesDAOMySql;
    private static MeetingsDAOMySql instance;

    public MeetingsDAOMySql(Connection connection) {
        super(connection);
        venuesDAOMySql = AbstractDAOFactory.getInstance().createVenuesDAOMySql(connection);
    }

    @Override
    public List<Meeting> getAll() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_MEETINGS)
             ) {
            List<Meeting> meetings = new ArrayList<>();
            while (resultSet.next()) {
                meetings.add(parseSetItem(resultSet));}
            return meetings;
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    public static synchronized MeetingsDAOMySql getInstance(Connection connection) {
        if (instance == null) {
            instance = new MeetingsDAOMySql(connection);
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }


    @Override
    public <T extends Entity> int insert(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(String.format(INSERT_INTO_MEETINGS))) {
            Meeting meeting = (Meeting) entity;
            preparedStatement.setString(1, meeting.getName());
            preparedStatement.setInt(2, meeting.getOrganizerID());
            preparedStatement.setDate(3, meeting.getTime());
            preparedStatement.setDate(4, meeting.getEndTime());
            venuesDAOMySql.insert(meeting.getVenue());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    @Override
    public Meeting getItemByID(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_MEETING_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return parseSetItem(resultSet);
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T extends Entity> int update(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MEETINGS)) {
            Meeting meeting = (Meeting) entity;
            preparedStatement.setString(1, meeting.getName());
            preparedStatement.setInt(2, meeting.getOrganizerID());
            preparedStatement.setDate(3, meeting.getTime());
            preparedStatement.setDate(4, meeting.getEndTime());
            preparedStatement.setInt(5, meeting.getMeetingID());
            venuesDAOMySql.update(meeting.getVenue());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    @Override
    public <T extends Entity> int delete(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MEETING_BY_ID )) {
            preparedStatement.setInt(1, ((Meeting) entity).getMeetingID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }


    private Meeting parseSetItem(ResultSet resultSet) throws SQLException {
        return new Meeting.MeetingBuilder()
                .setMeetingID(resultSet.getInt("meeting_id"))
                .setName(resultSet.getString("name"))
                .setOrganizerID(resultSet.getInt("organizer_id"))
                .setTime(resultSet.getDate("date"))
                .setEndTime(resultSet.getDate("end_time"))
                .setVenue(venuesDAOMySql.getItemByID(resultSet.getInt("venue_id")))
                .build();
    }

    public Meeting insertVenue(Venue venue, int meetingID) {
        venuesDAOMySql.insert(venue);
        return getItemByID(meetingID);
    }

    public Meeting updateVenue(Venue venue, int meetingID) {
        venuesDAOMySql.update(venue);
        return getItemByID(meetingID);
    }

//    public Meeting deleteVenue(Venue venue) {
//        userActivityDAOMySql.delete(userActivity);
//        return getItemByID(userActivity.getUser_id());
//    }
}

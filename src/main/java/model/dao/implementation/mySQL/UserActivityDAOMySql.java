package model.dao.implementation.mySQL;

import model.dao.BaseQueriesIF;
import model.dao.DaoIF;
import model.dao.factory.impl.MySqlDAOFactory;
import model.entity.Entity;
import model.entity.User;
import model.entity.UserActivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
public class UserActivityDAOMySql extends AbstractDAO implements BaseQueriesIF, DaoIF {
    private static UserActivityDAOMySql instance;
    public UserActivityDAOMySql(Connection connection) {
        super(connection);
    }

    public static synchronized UserActivityDAOMySql getInstance(Connection connection) {
        if (instance == null) {
            instance = new UserActivityDAOMySql(connection);
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    @Override
    public List<UserActivity> getAll() {
        return null;
    }

    public List<UserActivity> getAll(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ACTIVITY)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UserActivity> userActivities = new ArrayList<>();
            while (resultSet.next())
                userActivities.add(parseSetItem(resultSet));
            return userActivities;
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserActivity getItemByID(int id) {
        return null;
    }

    private UserActivity parseSetItem(ResultSet resultSet) throws SQLException {
        return new UserActivity.Builder()
                .setUser_id(resultSet.getInt("user_id"))
                .setReportRegistered(resultSet.getInt("report_id"))
                .setReportAttendance(resultSet.getBoolean("attendance_status"))
                .build();
    }

    @Override
    public <T extends Entity> int delete(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_ACTIVITY_BY_ID )) {
            preparedStatement.setInt(1, ((UserActivity) entity).getReportRegistered());
            preparedStatement.setInt(2, ((UserActivity) entity).getUser_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public <T extends Entity> int insert(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER_ACTIVITY)) {
            UserActivity userActivity = (UserActivity) entity;
            preparedStatement.setInt(1, userActivity.getUser_id());
            preparedStatement.setInt(2, userActivity.getReportRegistered());
            preparedStatement.setBoolean(3, userActivity.isReportAttendance());
            return preparedStatement.executeUpdate();
        } catch (SQLException | NullPointerException | ClassCastException e) {
//            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public <T extends Entity> int update(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_ACTIVITY)) {
            UserActivity userActivity = (UserActivity) entity;
            preparedStatement.setBoolean(1, userActivity.isReportAttendance());
            preparedStatement.setInt(2, userActivity.getUser_id());
            preparedStatement.setInt(3, userActivity.getReportRegistered());
            return preparedStatement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
//            e.printStackTrace();
        }
        return -1;
    }

    public int countReportAttenders(int reportID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REPORT_ATTENDERS)) {
            preparedStatement.setInt(1, reportID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("count_attended");
        } catch (SQLException | NullPointerException e) {
//            loggit
        }
        return 0;
    }

    public int countReportRegistered(int reportID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REPORT_REGISTERED)) {
            preparedStatement.setInt(1, reportID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.getInt("count_registered");
        } catch (SQLException | NullPointerException e) {
            //loggit
        }
        return 0;
    }
}

package model.dao.implementation.mySQL;

import model.dao.BaseQueriesIF;
import model.dao.DaoIF;
import model.entity.Entity;
import model.entity.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportsDAOMySql extends AbstractDAO implements BaseQueriesIF, DaoIF {
    private static ReportsDAOMySql instance;
    private UserActivityDAOMySql userActivityDAOMySql;

    public ReportsDAOMySql(Connection connection) {
        super(connection);
        userActivityDAOMySql = UserActivityDAOMySql.getInstance(connection);
    }

    public static synchronized ReportsDAOMySql getInstance(Connection connection) {
        if (instance == null) {
            instance = new ReportsDAOMySql(connection);
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    @Override
    public List<Report> getAll() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL + REPORTS_TABLE)
             ) {
            List<Report> reports = new ArrayList<>();
            while (resultSet.next()) {
                reports.add(parseSetItem(resultSet));
            }
            return reports;
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    public List<Report> getAllReportsForUserRegistered(int userID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REPORTS_USER_REGISTERED_FOR)
        ) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Report> reports = new ArrayList<>();
            while (resultSet.next()) {
                reports.add(parseSetItem(resultSet));
            }
            return reports;
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    private Report parseSetItem(ResultSet resultSet) throws SQLException {
        return new Report.ReportBuilder(resultSet.getString("title"))
                .setAttended(userActivityDAOMySql.countReportAttenders(resultSet.getInt("report_id")))
                .setRegistered(userActivityDAOMySql.countReportRegistered(resultSet.getInt("report_id")))
                .setSpeakerID(resultSet.getInt("speaker_id"))
                .setMeetingID(resultSet.getInt("meeting_id"))
                .setProposerID(resultSet.getInt("proposer_id"))
                .setStatus(resultSet.getString("status"))
                .setTime(resultSet.getDate("time"))
                .setEndTime(resultSet.getDate("end_time"))
                .setReportID(resultSet.getInt("report_id"))
                .build();
    }

    @Override
    public <T extends Entity> int delete(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REPORT_BY_ID)) {
            preparedStatement.setInt(1, ((Report) entity).getReportID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    @Override
    public <T extends Entity> int insert(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_REPORTS)) {
            Report report = (Report) entity;
            preparedStatement.setInt(1, report.getProposerID());
            preparedStatement.setInt(2, report.getMeetingID());
            preparedStatement.setInt(3, report.getSpeakerID());
            preparedStatement.setString(4, report.getTitle());
            preparedStatement.setInt(5, report.getRegistered());
            preparedStatement.setInt(6, report.getAttended());
            preparedStatement.setString(7, report.getStatus());
            preparedStatement.setDate(8, report.getTime());
            preparedStatement.setDate(9, report.getEndTime());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    public Report getItemByID(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL + REPORTS_TABLE + "WHERE report_id=" + id);
             ) {
            return parseSetItem(resultSet);
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    @Override
    public <T extends Entity> int update(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REPORTS)) {
            Report report = (Report) entity;
            preparedStatement.setInt(1, report.getRegistered());
            preparedStatement.setInt(2, report.getAttended());
            preparedStatement.setString(3, report.getTitle());
            preparedStatement.setString(4, report.getStatus());
            preparedStatement.setDate(5, report.getTime());
            preparedStatement.setDate(6, report.getEndTime());
            preparedStatement.setInt(7, report.getSpeakerID());
            preparedStatement.setInt(8, report.getProposerID());
            preparedStatement.setInt(9, report.getMeetingID());
            preparedStatement.setInt(10, report.getReportID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }
}

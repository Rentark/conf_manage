package service;

import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.ReportsDAOMySql;
import model.entity.Report;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportsService {
    private static ReportsService instance;
    private ReportsDAOMySql reportsDAOMySql = ReportsDAOMySql.getInstance(Connector.getConnection());

    private ReportsService() {
    }

    public static synchronized ReportsService getInstance() {
        if (instance == null) {
            instance = new ReportsService();
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    public List<Report> getReportsForMeeting(int meetingID) {
        List<Report> reportList = new ArrayList<>(reportsDAOMySql.getAll());
        return reportList.stream().filter(x -> x.getMeetingID() == meetingID).collect(Collectors.toList());
    }

    public List<Report> getReportsForUser(User user) {
        return new ArrayList<>(reportsDAOMySql.getAllReportsForUserRegistered(user.getUserID()));
    }

    public int editReport(Report report) {
        return reportsDAOMySql.update(report);
    }

    public int addReport(Report report) {
        return reportsDAOMySql.insert(report);
    }
}

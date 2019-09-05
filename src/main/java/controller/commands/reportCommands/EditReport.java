package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.Meeting;
import model.entity.Report;
import model.entity.User;
import service.MeetingsService;
import service.ReportsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditReport implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            ReportsService.getInstance().editReport(new Report.ReportBuilder(request.getParameter("title"))
                    .setMeetingID(Integer.parseInt(request.getParameter("meetingID")))
                    .setProposerID(Integer.parseInt(request.getParameter("proposerID")))
                    .setStatus(request.getParameter("reportStatus"))
                    .setReportID(Integer.parseInt(request.getParameter("reportID")))
                    .setTime((Date) simpleDateFormat.parse(request.getParameter("reportDate") + request.getParameter("reportTime")))
                    .build());
        } catch (ParseException e) {
            //loggit
        }

        return request.getSession().getAttribute("meetingItemPath").toString();
    }
}

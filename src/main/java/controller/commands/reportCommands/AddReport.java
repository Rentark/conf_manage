package controller.commands.reportCommands;

import controller.commands.Command;
import model.entity.Report;
import service.ReportsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddReport implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            ReportsService.getInstance().addReport(new Report.ReportBuilder(request.getParameter("title"))
                    .setMeetingID(Integer.parseInt(request.getParameter("meetingID")))
                    .setProposerID(Integer.parseInt(request.getParameter("proposerID")))
                    .setStatus(request.getParameter("reportStatus"))
                    .setTime((Date) simpleDateFormat.parse(request.getParameter("reportDate") + request.getParameter("reportTime")))
                    .build());
        } catch (ParseException e) {
            //loggit
        }

        return request.getSession().getAttribute("meetingItemPath").toString();
    }
}

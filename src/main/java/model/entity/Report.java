package model.entity;

import java.sql.Date;

public class Report extends Entity {
    private int reportID;
    private int speakerID;
    private int proposerID;
    private int meetingID;
    private int registered;
    private int attended;
    private Date time;
    private Date endTime;
    private String title;
    private String status;

    public Report() {
    }

    public Report(ReportBuilder reportBuilder) {
        this.reportID = reportBuilder.reportID;
        this.speakerID = reportBuilder.speakerID;
        this.proposerID = reportBuilder.proposerID;
        this.meetingID = reportBuilder.meetingID;
        this.registered = reportBuilder.registered;
        this.attended = reportBuilder.attended;
        this.title = reportBuilder.title;
        this.status = reportBuilder.status;
        this.time = reportBuilder.time;
        this.endTime = reportBuilder.endTime;
    }

    public int getReportID() {
        return reportID;
    }

    public int getSpeakerID() {
        return speakerID;
    }

    public int getProposerID() {
        return proposerID;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public int getRegistered() {
        return registered;
    }

    public int getAttended() {
        return attended;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public Date getTime() {
        return time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setSpeakerID(int speakerID) {
        this.speakerID = speakerID;
    }

    public void setProposerID(int proposerID) {
        this.proposerID = proposerID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ReportBuilder {
        private int reportID;
        private int speakerID;
        private int proposerID;
        private int meetingID;
        private int registered;
        private int attended;
        private Date time;
        private Date endTime;
        private String title;
        private String status;

        public ReportBuilder(String title) {
            this.title = title;
        }

        public ReportBuilder setReportID(int reportID) {
            this.reportID = reportID;
            return this;
        }

        public ReportBuilder setSpeakerID(int speakerID) {
            this.speakerID = speakerID;
            return this;
        }

        public ReportBuilder setProposerID(int proposerID) {
            this.proposerID = proposerID;
            return this;
        }

        public ReportBuilder setMeetingID(int meetingID) {
            this.meetingID = meetingID;
            return this;
        }

        public ReportBuilder setRegistered(int registered) {
            this.registered = registered;
            return this;
        }

        public ReportBuilder setAttended(int attended) {
            this.attended = attended;
            return this;
        }

        public ReportBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public ReportBuilder setTime(Date time) {
            this.time = time;
            return this;
        }

        public ReportBuilder setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}

package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class Meeting extends Entity implements Serializable {
    private int meetingID;
    private int organizerID;
    private String name;
    private Date time;
    private Date endTime;
    private Venue venue;

    public Meeting() {
    }

    public Meeting(MeetingBuilder meetingBuilder) {
        this.meetingID = meetingBuilder.meetingID;
        this.organizerID = meetingBuilder.organizerID;
        this.name = meetingBuilder.name;
        this.time = meetingBuilder.time;
        this.endTime = meetingBuilder.endTime;
        this.venue = meetingBuilder.venue;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public String getName() {
        return name;
    }

    public Date getTime() {
        return time;
    }

    public Venue getVenue() {
        return venue;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public static class MeetingBuilder {
        private int meetingID;
        private int organizerID;
        private String name;
        private Date time;
        private Date endTime;
        private Venue venue;

        public MeetingBuilder() {
        }

        public MeetingBuilder setMeetingID(int meetingID) {
            this.meetingID = meetingID;
            return this;
        }

        public MeetingBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MeetingBuilder setOrganizerID(int organizerID) {
            this.organizerID = organizerID;
            return this;
        }

        public MeetingBuilder setTime(Date time) {
            this.time = time;
            return this;
        }

        public MeetingBuilder setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public MeetingBuilder setVenue(Venue venue) {
            this.venue = venue;
            return this;
        }

        public Meeting build() {
            return new Meeting(this);
        }
    }
}

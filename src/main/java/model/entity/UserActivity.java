package model.entity;

import java.util.HashMap;

public class UserActivity extends Entity {
    private int user_id;
    private int reportRegistered;
    private boolean reportAttendance;

    public UserActivity() {
    }

    public UserActivity(Builder builder) {
        this.reportAttendance = builder.reportAttendance;
        this.reportRegistered = builder.reportRegistered;
        this.user_id = builder.user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getReportRegistered() {
        return reportRegistered;
    }

    public boolean isReportAttendance() {
        return reportAttendance;
    }

    public void setReportAttendance(boolean reportAttendance) {
        this.reportAttendance = reportAttendance;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setReportRegistered(int reportRegistered) {
        this.reportRegistered = reportRegistered;
    }

    public static class Builder {
        private int user_id;
        private int reportRegistered;
        private boolean reportAttendance;

        public Builder() {}

        public Builder setUser_id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setReportRegistered(int reportRegistered) {
            this.reportRegistered = reportRegistered;
            return this;
        }

        public Builder setReportAttendance(boolean reportAttendance) {
            this.reportAttendance = reportAttendance;
            return this;
        }

        public UserActivity build() {
            return new UserActivity(this);
        }
    }
}

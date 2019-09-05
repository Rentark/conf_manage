package util;

public enum Paths {
    ADD_MEETING("addMeeting", "meetingManagement"),
    EDIT_MEETING_INFO("editMeeting", "meetingManagement"),
    DELETE_MEETING("deleteMeeting", "meetingManagement"),
    SHOW_MEETINGS_LIST("/meetings", "meetingsList"),
    SHOW_MEETING_INFO("/meetings/meeting/[0-9]+", "meetingInfo"),
    USER_REPORT_REGISTER("/meetings/meeting/reportUserActivity", "reportUserActivity"),
//    REPORT_USER_REGISTER("/reportUserActivity", "reportUserActivity"),
    REPORT_USER_REGISTER("registerForRep", "reportUserActivity"),
    REPORT_USER_UNREGISTER("unRegisterForRep", "reportUserActivity"),
//    REPORT_USER_ATTENDANCE("/reportUserActivity", "reportUserActivity"),
    REPORT_USER_SET_ATTENDANCE("setAttendance", "reportUserActivity"),
    REPORT_USER_UNSET_ATTENDANCE("unSetAttendance", "reportUserActivity"),
    SHOW_USER_INFO("/user/[0-9]+", "userInfo"),
    EDIT_USER_INFO("/editUserInfo", "editUserInfo"),
    SHOW_MANAGEMENT_MEETINGS_LIST("/management/meetings", "meetingsList"),
    SHOW_MANAGEMENT_MEETING_INFO("/management/meetings/meeting/[0-9]+", "meetingInfo");

    private String regex;
    private String query;

    Paths(String regex, String query) {
        this.regex = regex;
        this.query = query;
    }

    public String getRegex() {
        return regex;
    }

    public String getQuerry() {
        return query;
    }
}

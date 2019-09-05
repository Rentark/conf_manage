package model.dao;

public interface BaseQueriesIF {
    String GET_ALL = "SELECT * FROM ";
    String GET_ALL_USERS = "SELECT * FROM users";
    String GET_ALL_MEETINGS = "SELECT * FROM meetings";
    String GET_ALL_USERS_LOGIN_DATA = "SELECT * FROM users AS u WHERE u.login=? AND u.password=?";
    String GET_USER_BY_ID = "SELECT * FROM users WHERE user_id=?";

    String GET_MEETING_BY_ID = "SELECT * FROM meetings WHERE meeting_id=?";
    String MEETINGS_TABLE = "meetings";
    String DELETE_MEETING_BY_ID = "DELETE FROM meetings WHERE meeting_id=?";
    String INSERT = "INSERT INTO ? VALUES ";
    String INSERT_INTO_USER = "INSERT INTO users (login,password,first_name,last_name,role) VALUES (?,?,?,?,?)";
    String INSERT_INTO_MEETINGS = "INSERT INTO meetings (name,organizer_id,date,end_time) VALUES (?,?,?,?)";
    String INSERT_INTO_USER_ACTIVITY = "INSERT INTO user_activity (user_id,report_id,attendance_status) VALUES (?,?,?)";
    String INSERT_INTO_REPORTS = "INSERT INTO reports (organizer_id,meeting_id,speaker_id,title,registered,attended,status,end_time) VALUES (?,?,?,?,?,?,?,?,?)";

    String UPDATE_MEETINGS = "UPDATE meetings SET name=?, organizer_id=?, time=? end_time=? WHERE meeting_id=?";
    String UPDATE_REPORTS = "UPDATE reports SET registered=?, attended=?, title=?, status=?, time=?, end_time=? speaker_id=?, proposer_id=?, meeting_id=? WHERE report_id=?";
    String UPDATE_USER_ACTIVITY = "UPDATE user_activity SET attendance_status=? WHERE user_id=? AND report_id=?";
    String UPDATE_USER = "UPDATE users SET password=? first_name=? last_name=? role=? rating=? bonuses=? login=? WHERE user_id=?";

    String COUNT_REPORT_ATTENDERS = "SELECT user_id, COUNT(*) AS count_attended FROM user_activity WHERE attendance_status=true AND report_id=? GROUP BY user_id";
    String COUNT_REPORT_REGISTERED = "SELECT user_id, COUNT(*) AS count_registered FROM user_activity WHERE report_id=? GROUP BY user_id";

    String GET_ALL_REPORTS_USER_REGISTERED_FOR = "SELECT * FROM reports AS r INNER JOIN user_activity AS u_a ON r.report_id=u_a.report_id AND u_a.user_id=?";

    String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id=?";
    String DELETE_REPORT_BY_ID = "DELETE FROM reports WHERE user_id=?";

    String REPORTS_TABLE = "reports";

    String GET_ALL_VENUES = "SELECT * FROM venues";
    String DELETE_VENUE_BY_ID = "DELETE FROM venues WHERE venue_id=?";
    String INSERT_INTO_VENUES = "INSERT INTO venues (venue_id,city,house,room,street) VALUES (?,?,?,?,?)";
    String GET_VENUE_BY_MEETING_ID = "SELECT v.* FROM venues AS v WHERE v.venue_id=(SELECT m.venue_id FROM meetings AS m WHERE m.meeting_id=?)";
    String GET_VENUE_BY_ID = "SELECT * FROM venues WHERE venue_id=?";
    String UPDATE_VENUES = "UPDATE venues SET city=?, house=?, room=? street=? WHERE venue_id=?";

    String GET_USER_ACTIVITY = "SELECT * FROM user_activity AS u_a WHERE u_a.user_id=?";
    String DELETE_USER_ACTIVITY_BY_ID = "DELETE FROM user_activity WHERE report_id=? AND user_id=?";
}

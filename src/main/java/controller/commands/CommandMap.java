package controller.commands;

import controller.commands.meetingsCommands.AddMeeting;
import controller.commands.meetingsCommands.EditMeetingInfo;
import controller.commands.meetingsCommands.ShowMeetingInfo;
import controller.commands.meetingsCommands.ShowMeetingsList;
import controller.commands.reportCommands.ReportUserSetAttendance;
import controller.commands.reportCommands.ReportUserRegister;
import controller.commands.reportCommands.ReportUserUnRegister;
import controller.commands.reportCommands.ReportUserUnSetAttendance;
import controller.commands.userCommands.EditProfileUserData;
import controller.commands.userCommands.ShowProfileUserInfo;
import util.Paths;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private static final Map<String, Command> COMMAND_MAP;

    static {
        final Map<String, Command> commands = new HashMap<>();

        commands.put(Paths.SHOW_MEETINGS_LIST.name(), new ShowMeetingsList());
        commands.put(Paths.SHOW_MANAGEMENT_MEETINGS_LIST.name(), new ShowMeetingsList());
        commands.put(Paths.SHOW_MEETING_INFO.name(), new ShowMeetingInfo());
        commands.put(Paths.SHOW_MANAGEMENT_MEETING_INFO.name(), new ShowMeetingInfo());
        commands.put(Paths.ADD_MEETING.name(), new AddMeeting());
        commands.put(Paths.EDIT_MEETING_INFO.name(), new EditMeetingInfo());
        commands.put(Paths.REPORT_USER_REGISTER.name(), new ReportUserRegister());
        commands.put(Paths.REPORT_USER_UNREGISTER.name(), new ReportUserUnRegister());
        commands.put(Paths.REPORT_USER_SET_ATTENDANCE.name(), new ReportUserSetAttendance());
        commands.put(Paths.REPORT_USER_UNSET_ATTENDANCE.name(), new ReportUserUnSetAttendance());
        commands.put(Paths.SHOW_USER_INFO.name(), new ShowProfileUserInfo());
        commands.put(Paths.EDIT_USER_INFO.name(), new EditProfileUserData());

        COMMAND_MAP = Collections.unmodifiableMap(commands);
    }

    public static Command getCommand(String commandString) throws NullPointerException{
        Command command = COMMAND_MAP.get(commandString);
        if (command == null )  throw new NullPointerException();
        return command;   //loggit instead of null
    }
}
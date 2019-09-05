package controller.commands.userCommands;

import controller.commands.Command;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class EditAnyUserData implements Command {
    @Override
    public String execute(HttpServletRequest request) {
                UsersService.getInstance()
                        .updateUser(request, UsersService.getInstance()
                                .getUserByID(Integer.parseInt(request.getParameter("userID"))));

        return request.getSession().getAttribute("UserPageItemPathSession").toString();
    }
}

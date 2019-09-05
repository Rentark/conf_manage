package controller.commands.userCommands;

import controller.commands.Command;
import model.entity.User;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;

public class EditProfileUserData implements Command {
    public EditProfileUserData() {
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().setAttribute("userSession",
                UsersService.getInstance()
                        .updateUser(request, (User) request.getSession().getAttribute("userSession")));

        return request.getSession().getAttribute("UserPageItemPathSession").toString();
    }
}

package service;

import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.MeetingsDAOMySql;
import model.dao.implementation.mySQL.UserActivityDAOMySql;
import model.dao.implementation.mySQL.UsersDAOMySql;
import model.entity.Meeting;
import model.entity.Roles;
import model.entity.User;
import model.entity.UserActivity;

import java.sql.SQLException;
import java.util.List;

public class Service {
    private UsersDAOMySql usersDAOMySql;

    public Service() {
        this.usersDAOMySql = AbstractDAOFactory.getInstance().createUsersDAO(Connector.getConnection());
    }

    public int registerUser(String login, String password, String firstName, String lastName) {
        return usersDAOMySql.insert(new User.UserBuilder(login, password, firstName, lastName).setRole(Roles.USER.getRole()).build());
    }

}

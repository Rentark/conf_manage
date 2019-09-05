package service;

import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.UsersDAOMySql;
import model.entity.User;

import java.sql.SQLException;

public class LoginService {
    private UsersDAOMySql usersDAOMySql = AbstractDAOFactory.getInstance().createUsersDAO(Connector.getConnection());
    private static LoginService instance;

    private LoginService() {
    }

    public static synchronized LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }


//    public LoginService() {
//        this.usersDAOMySql = AbstractDAOFactory.getInstance().createUsersDAO(Connector.getConnection());
//    }

    public User validateUser(String login, String password) throws SQLException {
        return usersDAOMySql.getUserByLoginData(login, password);
    }


}

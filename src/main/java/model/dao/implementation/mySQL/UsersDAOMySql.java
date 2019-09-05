package model.dao.implementation.mySQL;

import model.dao.BaseQueriesIF;
import model.dao.DaoIF;
import model.dao.connector.Connector;
import model.dao.factory.AbstractDAOFactory;
import model.entity.Entity;
import model.entity.User;
import model.entity.UserActivity;

import java.sql.*;
import java.util.*;

@SuppressWarnings("ALL")
public class UsersDAOMySql extends AbstractDAO implements BaseQueriesIF, DaoIF {
    private UserActivityDAOMySql userActivityDAOMySql;
    private static UsersDAOMySql instance;

    private UsersDAOMySql(Connection connection) {
        super(connection);
        userActivityDAOMySql = UserActivityDAOMySql.getInstance(connection);
    }

    public static synchronized UsersDAOMySql getInstance(Connection connection) {
        if (instance == null) {
            instance = new UsersDAOMySql(connection);
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    public User getUserByLoginData(String login, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_LOGIN_DATA)
            ) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? parseSetItem(resultSet) : null;
        } catch (SQLException e) {
            //loggit
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try (Statement statement = connection.createStatement();
             ResultSet userBaseData = statement.executeQuery(GET_ALL_USERS);
//             ResultSet userActivityData = statement.executeQuery(GET_USER_ACTIVITY);
             ) {
            List<User> users = new ArrayList<>();
            while (userBaseData.next()) {
                users.add(parseSetItem(userBaseData));
            }
            return users;
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    private User parseSetItem(ResultSet userBaseData) throws SQLException {
            return new User.UserBuilder(userBaseData.getString("login"),
                    userBaseData.getString("password"),
                    userBaseData.getString("first_name"),
                    userBaseData.getString("last_name"))
                    .setUserID(userBaseData.getInt("user_id"))
                    .setRole(userBaseData.getString("role"))
                    .setBonuses(userBaseData.getDouble("bonuses"))
                    .setRating(userBaseData.getDouble("rating"))
                    .setUserActivity(userActivityDAOMySql.getAll(userBaseData.getInt("user_id")))
                    .build();
    }

    @Override
    public <T extends Entity> int delete(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            preparedStatement.setInt(1, ((User) entity).getUserID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return -1;
    }

    @Override
    public <T extends Entity> int insert(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER)) {
            User user = (User) entity;
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getRole());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return -1;
    }

    @Override
    public User getItemByID(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            return parseSetItem(preparedStatement.executeQuery());
        } catch (SQLException exp) {
            //loggit
     }
        return null;
    }

    @Override
    public <T extends Entity> int update(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            User user = (User) entity;
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setDouble(5, user.getRating());
            preparedStatement.setDouble(6, user.getBonuses());
            preparedStatement.setString(7, user.getLogin());
            preparedStatement.setInt(8, user.getUserID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return -1;
    }

    public User insertUserActivity(UserActivity entity) {
        userActivityDAOMySql.insert(entity);
        return getItemByID(entity.getUser_id());
    }

    public User updateUserActivity(UserActivity userActivity) {
        userActivityDAOMySql.update(userActivity);
        return getItemByID(userActivity.getUser_id());
    }

    public User deleteUserActivity(UserActivity userActivity) {
        userActivityDAOMySql.delete(userActivity);
        return getItemByID(userActivity.getUser_id());
    }

}

package model.dao.factory.impl;

import model.dao.factory.AbstractDAOFactory;
import model.dao.implementation.mySQL.*;

import java.sql.Connection;

public class MySqlDAOFactory extends AbstractDAOFactory {

    @Override
    public UsersDAOMySql createUsersDAO(Connection connection) {
        return UsersDAOMySql.getInstance(connection);
    }

    @Override
    public ReportsDAOMySql createReportsDAO(Connection connection) {
        return ReportsDAOMySql.getInstance(connection);
    }

    @Override
    public MeetingsDAOMySql createMeetingsDAO(Connection connection) {
        return MeetingsDAOMySql.getInstance(connection);
    }

    @Override
    public UserActivityDAOMySql createUserActivityDAO(Connection connection) {
        return UserActivityDAOMySql.getInstance(connection);
    }

    @Override
    public VenuesDAOMySql createVenuesDAOMySql(Connection connection) {
        return VenuesDAOMySql.getInstance(connection);
    }


//    public boolean delete(int id);
//    public abstract String getSQL_FOR_DEL();
//    public abstract <T> boolean insert(T entity);
////    public abstract <T> T getItemByID(int id);
//    public abstract <T> boolean update(T entity);


    //change 'prepared statement' to 'statement'?
//    public boolean delete2(int id) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(this.getSQL_FOR_DEL())) {
//            preparedStatement.setInt(1, id);
//            return preparedStatement.execute();
//        } catch (SQLException e) {
//            //loggit
//        }
//        return false;
//    }

    //protected abstract <T> List<T> parseSet(ResultSet resultSet) throws SQLException;
//
//    public void close(Statement st) {
//        try {
//            if (st != null)
//                st.close();
//        } catch (SQLException e) {
//            //loggit
//        }
//    }


}

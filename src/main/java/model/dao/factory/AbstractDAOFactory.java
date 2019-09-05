package model.dao.factory;

import model.dao.factory.impl.MySqlDAOFactory;
import model.dao.implementation.mySQL.*;

import java.sql.Connection;

public abstract class AbstractDAOFactory {
    private static volatile AbstractDAOFactory abstractDAOFactory;

    public abstract UsersDAOMySql createUsersDAO(Connection connection);
    public abstract ReportsDAOMySql createReportsDAO(Connection connection);
    public abstract MeetingsDAOMySql createMeetingsDAO(Connection connection);
    public abstract UserActivityDAOMySql createUserActivityDAO(Connection connection);
    public abstract VenuesDAOMySql createVenuesDAOMySql(Connection connection);

    /**
     * @return abstractDAOFactory
     */
    public static AbstractDAOFactory getInstance() {
        if( abstractDAOFactory == null ){
            synchronized (AbstractDAOFactory.class){
                if(abstractDAOFactory == null){
                    abstractDAOFactory = new MySqlDAOFactory();
                }
            }
        }
        return abstractDAOFactory;
    }
}

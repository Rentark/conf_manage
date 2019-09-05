package model.dao.connector;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {
    private static volatile DataSource dataSource;
//    public static Connection createConnection() throws SQLException {
//        ResourceBundle resource =
//                ResourceBundle.getBundle("database");
//        String url = resource.getString("url");
//        String user = resource.getString("user");
//        String pass = resource.getString("password");
//        return DriverManager.getConnection(url, user, pass);
//    }

    private static DataSource getDataSource() {
        if(dataSource == null){
            synchronized (Connector.class){
                if(dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ResourceBundle resource = ResourceBundle.getBundle("database");
                    ds.setDriverClassName(resource.getString("db.driver"));
                    ds.setUrl(resource.getString("url"));
                    ds.setUsername(resource.getString("user"));
                    ds.setPassword(resource.getString("password"));
                    ds.setMinIdle(Integer.valueOf(resource.getString("min")));
                    ds.setMaxIdle(Integer.valueOf(resource.getString("max")));
                    ds.setMaxOpenPreparedStatements(Integer.valueOf(resource.getString("statements")));
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

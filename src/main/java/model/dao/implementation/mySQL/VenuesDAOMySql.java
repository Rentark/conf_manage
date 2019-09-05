package model.dao.implementation.mySQL;

import model.dao.BaseQueriesIF;
import model.dao.DaoIF;
import model.entity.Entity;
import model.entity.Venue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class VenuesDAOMySql extends AbstractDAO implements BaseQueriesIF, DaoIF {
    private static VenuesDAOMySql instance;
    public VenuesDAOMySql(Connection connection) {
        super(connection);
    }

    public static synchronized VenuesDAOMySql getInstance(Connection connection) {
        if (instance == null) {
            instance = new VenuesDAOMySql(connection);
//            log.info("LoginService instance created");
        }
//        log.info("LoginService instance supplied");
        return instance;
    }

    @Override
    public List<Venue> getAll() {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_VENUES)
        ) {
            List<Venue> venues = new ArrayList<>();
            while (resultSet.next()) {
                venues.add(parseSetItem(resultSet));}
            return venues;
        } catch (SQLException exp) {
            //loggit
        }
        return null;
    }

    @Override
    public <T extends Entity> int delete(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VENUE_BY_ID )) {
            preparedStatement.setInt(1, ((Venue) entity).getVenueID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    @Override
    public <T extends Entity> int insert(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_VENUES)) {
            Venue venue = (Venue) entity;
            preparedStatement.setString(2, venue.getCity());
            preparedStatement.setString(3, venue.getHouse());
            preparedStatement.setString(4, venue.getRoom());
            preparedStatement.setString(5, venue.getStreet());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    @Override
    public Venue getItemByID(int venueID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_VENUE_BY_ID);
        ) {
            preparedStatement.setInt(1, venueID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return (resultSet.next()) ? parseSetItem(resultSet) : null;
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T extends Entity> int update(T entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VENUES)) {
            Venue venue = (Venue) entity;
            preparedStatement.setString(1, venue.getCity());
            preparedStatement.setString(2, venue.getHouse());
            preparedStatement.setString(3, venue.getRoom());
            preparedStatement.setString(4, venue.getStreet());
            preparedStatement.setInt(5, venue.getVenueID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //loggit
        }
        return 0;
    }

    private Venue parseSetItem(ResultSet resultSet) throws SQLException {
        return new Venue.Builder()
                .setCity(resultSet.getString("city"))
                .setStreet(resultSet.getString("street"))
                .setHouse(resultSet.getString("house"))
                .setRoom(resultSet.getString("room"))
                .setVenueID(resultSet.getInt("venue_id"))
                .build();
    }
}

package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.stereotype.Repository;
import org.sqlite.SQLiteConnection;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftBuilder;
import sbitneva.entity.aircrafts.AircraftFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
@Qualifier("aircraftsDao")
public class AircraftsDao {

    private static Logger log = Logger.getLogger(AircraftsDao.class.getName());

    private static final String READ_REQUEST = "select * from aircrafts inner join aircraft_types on " +
            "(aircrafts.id = ? and aircrafts.type_id = aircraft_types.id)";
    private static final String READ_ALL_REQUEST = "select * from aircrafts inner join aircraft_types on " +
            "(aircrafts.type_id = aircraft_types.id);";
    private static final String DELETE_AIRCRAFT = "delete from aircrafts where id=?;";
    private static final String CREATE_AIRCRAFT = "insert into aircrafts " +
            "(name, type_id, carriage_capacity, fuel_consumption, flight_range) values ( ?, ?, ?, ?, ?)";
    private static final String UPDATE_AIRCRAFT = "update aircrafts set" +
            " name=?, type_id=?,  carriage_capacity=?, fuel_consumption=?, flight_range=? where id=?;";
    private static final String FIND_BY_RANGE_AIRCRAFT = "select * from aircrafts where (fuel_consumption between ? and ?)";


    @Autowired
    private DataSource dataSource;

    public void create(Aircraft aircraft) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_AIRCRAFT)) {

             statement.setString(1, aircraft.getName());
            statement.setInt(2, aircraft.getTypeId());
            statement.setInt(3, aircraft.getCarriageCapacity());
            statement.setInt(4, aircraft.getFuelConsumption());
            statement.setInt(5, aircraft.getFlightRange());

            statement.execute();

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

    }

    public Aircraft read(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Aircraft aircraft =  new AircraftBuilder()
                                    .setId(resultSet.getInt("id"))
                                    .setName(resultSet.getString("name"))
                                    .setTypeId(resultSet.getInt("type_id"))
                                    .setCarriageCapacity(resultSet.getInt("carriage_capacity"))
                                    .setFuelConsumption(resultSet.getInt("fuel_consumption"))
                                    .setFlightRange(resultSet.getInt("flight_range"))
                                    .setType(resultSet.getString("type_name"))
                                    .buildAircraft();
                return aircraft;
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

        return null;
    }

    public void update(int id, Aircraft aircraft) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_AIRCRAFT)) {

            statement.setString(1, aircraft.getName());
            statement.setInt(2, aircraft.getTypeId());
            statement.setInt(3, aircraft.getCarriageCapacity());
            statement.setInt(4, aircraft.getFuelConsumption());
            statement.setInt(5, aircraft.getFlightRange());
            statement.setInt(6, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

    }

    public void delete(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_AIRCRAFT)) {

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }
    }

    public ArrayList<Aircraft> readAllAircrafts() {

        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_REQUEST)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                aircrafts.add(new AircraftBuilder()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setCarriageCapacity(resultSet.getInt("carriage_capacity"))
                        .setFuelConsumption(resultSet.getInt("fuel_consumption"))
                        .setFlightRange(resultSet.getInt("flight_range"))
                        .setType(resultSet.getString("type_name"))
                        .buildAircraft());
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

        return aircrafts;
    }

    public ArrayList<Aircraft> findByFuelRange(int min, int max) {

        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_RANGE_AIRCRAFT)) {
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Aircraft aircraft = AircraftFactory.getAircraft(resultSet.getInt("type_id"));

                aircraft.setId(resultSet.getInt("id"));
                aircraft.setName(resultSet.getString("name"));
                aircraft.setTypeId(resultSet.getInt("type_id"));
                aircraft.setCarriageCapacity(resultSet.getInt("carriage_capacity"));
                aircraft.setFuelConsumption(resultSet.getInt("fuel_consumption"));
                aircraft.setFlightRange(resultSet.getInt("flight_range"));
                aircrafts.add(aircraft);
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }

        return aircrafts;
    }


}

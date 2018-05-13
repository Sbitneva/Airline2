package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import sbitneva.entity.aircrafts.CargosAirplane;
import sbitneva.entity.aircrafts.CargosHelicopter;
import sbitneva.entity.aircrafts.PassengerAirplane;
import sbitneva.entity.aircrafts.PassengerHelicopter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("aircraftTypesDao")
public class AircraftTypesDao {

    private static Logger log = Logger.getLogger(AircraftTypesDao.class.getName());

    private static Map<String, String> typesAndClasses = new HashMap<>();

    private static final String GET_TYPE = "select id from aircraft_types where type_name = ?;";

    private static final String CARGO_HELICOPTER = "cargo helicopter";
    private static final String CARGO_AIRPLANE = "cargo aircraft";

    private static final String PASS_HELICOPTER = "passenger helicopter";
    private static final String PASS_AIRPLANE = "passenger aircraft";

    private static void fillMap(){
        typesAndClasses.put(CargosHelicopter.class.getSimpleName(), CARGO_HELICOPTER);
        typesAndClasses.put(CargosAirplane.class.getSimpleName(), CARGO_AIRPLANE);
        typesAndClasses.put(PassengerHelicopter.class.getSimpleName(), PASS_HELICOPTER);
        typesAndClasses.put(PassengerAirplane.class.getSimpleName(), PASS_AIRPLANE);
    }

    public AircraftTypesDao(){
        if(typesAndClasses.isEmpty()) {
            fillMap();
        }
    }

    @Autowired
    private DataSource dataSource;

    public int getAircraftType(String className){
        int typeId = 0;
        String typeName = typesAndClasses.get(className);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_TYPE)) {
            statement.setString(1, typeName);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                typeId = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }
        return typeId;
    }

}

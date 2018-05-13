package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbitneva.TestConfiguration;
import sbitneva.entity.aircrafts.CargosAirplane;
import sbitneva.entity.aircrafts.CargosHelicopter;
import sbitneva.entity.aircrafts.PassengerAirplane;
import sbitneva.entity.aircrafts.PassengerHelicopter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)

public class AircraftTypesTests {

    private static Logger log = Logger.getLogger(AircraftTypesTests.class.getName());

    @Mock
    @Autowired
    private DataSource dataSource;

    @InjectMocks
    @Autowired
    private AircraftTypesDao aircraftTypesDao;

    @Before
    public void setUp() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("restore from airline_test.db");
        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }
    }

    @Test
    public void getTypeIdTest(){
        assertEquals(aircraftTypesDao.getAircraftType(CargosAirplane.class.getSimpleName()), 4);
        assertEquals(aircraftTypesDao.getAircraftType(CargosHelicopter.class.getSimpleName()), 2);
        assertEquals(aircraftTypesDao.getAircraftType(PassengerAirplane.class.getSimpleName()), 1);
        assertEquals(aircraftTypesDao.getAircraftType(PassengerHelicopter.class.getSimpleName()), 3);
    }

}

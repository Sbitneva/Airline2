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
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.CargosAirplane;
import sbitneva.entity.aircrafts.PassengerAirplane;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)

public class AircraftsDaoTest {

    private static Logger log = Logger.getLogger(AircraftsDaoTest.class.getName());

    @Mock
    @Autowired
    private DataSource dataSource;

    @InjectMocks
    @Autowired
    private AircraftsDao aircraftsDao;
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
    public void readTest() {
        Aircraft aircraft = aircraftsDao.read(1);
        assertEquals(aircraft.getClass().getSimpleName(), "CargosHelicopter");
        assertEquals(2, aircraft.getTypeId());
        assertEquals(aircraft.getName(), "Volchara");
        assertEquals(aircraft.getFlightRange(), 5000);
    }

    @Test
    public void deleteTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);
        aircraftsDao.delete(1);
        aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 3);

    }

    @Test
    public void updateTest() {
        int id = 1;
        Aircraft aircraft = new CargosAirplane();
        aircraft.setTypeId(aircraftTypesDao.getAircraftType(aircraft.getClass().getSimpleName()));
        aircraft.setCarriageCapacity(60000);
        aircraft.setFlightRange(10000);
        aircraft.setName("Test");
        aircraft.setFuelConsumption(20000);

        aircraftsDao.update(id, aircraft);

        Aircraft aircraft_after = aircraftsDao.read(1);

        assertEquals(id, aircraft_after.getId());
        assertEquals(aircraft.getName(), aircraft_after.getName());
        assertEquals(aircraft.getTypeId(), aircraft_after.getTypeId());
        assertEquals(aircraft.getCarriageCapacity(), aircraft_after.getCarriageCapacity());
        assertEquals(aircraft.getFlightRange(), aircraft_after.getFlightRange());
        assertEquals(aircraft.getFuelConsumption(), aircraft_after.getFuelConsumption());

    }

    @Test
    public void createTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);

        Aircraft aircraft = new PassengerAirplane();
        aircraft.setTypeId(1);
        aircraft.setCarriageCapacity(5000);
        aircraft.setFuelConsumption(6000);
        aircraft.setFlightRange(2000);
        aircraft.setName("OREL");

        aircraftsDao.create(aircraft);

        aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 5);
        Aircraft aircraft1 = aircraftsDao.read(5);
        assertEquals(aircraft1.getCarriageCapacity(), 5000);
        assertEquals(aircraft1.getName(), "OREL");
        assertEquals(aircraft1.getTypeId(), 1);
    }

    @Test
    public void readAllTest() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        assertEquals(aircrafts.size(), 4);

    }

    @Test
    public void findInRange(){
        ArrayList<Aircraft> aircrafts = aircraftsDao.findByFuelRange(4000, 5000);
        assertEquals(aircrafts.size(), 1);
        assertEquals(aircrafts.get(0).getId(), 4);
    }

}

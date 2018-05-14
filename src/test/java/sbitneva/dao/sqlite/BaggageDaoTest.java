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

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)

public class BaggageDaoTest {
    private static Logger log = Logger.getLogger(AircraftTypesTest.class.getName());

    @Mock
    @Autowired
    private DataSource dataSource;

    @InjectMocks
    @Autowired
    private BaggageDao baggageDao;

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
    public void calcTest() {
        int capacity = baggageDao.calcCapacity();
        assertEquals(13700, capacity);
    }


}

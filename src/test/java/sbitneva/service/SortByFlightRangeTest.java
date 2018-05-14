package sbitneva.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sbitneva.TestConfiguration;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.CargosAirplane;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class SortByFlightRangeTest {

    private ArrayList<Aircraft> aircrafts = new ArrayList<>();
    private ArrayList<Aircraft> aircrafts2 = new ArrayList<>();

    @InjectMocks
    private SortByFlightRange sortByFlightRange;

    @Mock
    private AircraftsDao aircraftsDao;

    @Before
    public void setUp(){

        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosAirplane());

        int i = aircrafts.size();
        for(Aircraft aircraft : aircrafts){
            aircraft.setFlightRange(i * 1000);
            i--;
        }
        i = aircrafts2.size();
        for(Aircraft aircraft : aircrafts2){
            aircraft.setFlightRange(i * 1000);
            i--;
        }

    }

    @Test
    public void sortTest(){

        for(int i = 0; i < aircrafts.size(); i++) {
            assertTrue(aircrafts.get(i).getFlightRange() == aircrafts2.get(i).getFlightRange());
        }
        when(aircraftsDao.readAllAircrafts()).thenReturn(aircrafts);

        sortByFlightRange.sort();

        int j = aircrafts.size() - 1 ;

        for(int i = 0; i < aircrafts.size(); i++) {
            assertTrue(aircrafts.get(j).getFlightRange() == aircrafts2.get(i).getFlightRange());
            j--;
        }
    }

}

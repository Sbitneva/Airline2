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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)


public class SortByFlightRangeTest {

    private ArrayList<Aircraft> aircrafts = new ArrayList<>();

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
        int i = aircrafts.size();
        for(Aircraft aircraft : aircrafts) {
            aircraft.setFlightRange(i * 1000);
            i--;
        }

    }

    @Test
    public void sortTest(){
        when(aircraftsDao.readAllAircrafts()).thenReturn(aircrafts);
        sortByFlightRange.sort();
    }

}

package sbitneva.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CrudServiceTest {

    @InjectMocks
    private CrudService crudService;

    @Mock
    private AircraftsDao aircraftsDao;

    private Aircraft aircraft;

    @Before
    public void setUp() {
        aircraft = AircraftFactory.getAircraft(2);
        aircraft.setTypeId(2);
        aircraft.setFuelConsumption(5000);
        aircraft.setFlightRange(100000);
        aircraft.setName("Test");
    }


    @Test
    public void delete() {
        crudService.delete(1);
        verify(aircraftsDao, times(1)).delete(anyInt());
    }

    @Test
    public void add() {
        crudService.add(aircraft);
        verify(aircraftsDao, times(1)).create(any());
    }

    @Test
    public void edit() {
        crudService.edit(1, aircraft);
        verify(aircraftsDao, times(1)).update(anyInt(), any());
    }

    @Test
    public void read() {
        crudService.read(1);
        verify(aircraftsDao, times(1)).read(anyInt());
    }
}

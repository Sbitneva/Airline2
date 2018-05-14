package sbitneva.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ShowAllAircraftsClass {

    private ArrayList<Aircraft> aircrafts = new ArrayList<>();
    private ArrayList<Aircraft> aircrafts2 = new ArrayList<>();

    @InjectMocks
    private ShowAllAircraftsService showAllAircraftsService;

    @Mock
    private AircraftsDao aircraftsDao;

    @Before
    public void setUp() {

        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosHelicopter());
        aircrafts.add(new PassengerAirplane());
        aircrafts.add(new CargosAirplane());
        aircrafts.add(new CargosHelicopter());
        aircrafts.add(new PassengerAirplane());
        aircrafts.add(new PassengerHelicopter());

        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosHelicopter());
        aircrafts2.add(new PassengerAirplane());
        aircrafts2.add(new CargosAirplane());
        aircrafts2.add(new CargosHelicopter());
        aircrafts2.add(new PassengerAirplane());
        aircrafts2.add(new PassengerHelicopter());

        int i = 0;
        for(Aircraft aircraft : aircrafts){
            aircraft.setFlightRange(i * 1000);
            aircrafts2.get(i).setFlightRange(i * 1000);
            aircraft.setName("Cat" + i);
            aircrafts2.get(i).setName("Cat" + i);
            aircraft.setCarriageCapacity(2 * i * 1000);
            aircrafts2.get(i).setCarriageCapacity(2 * i * 1000);
            aircraft.setId(i);
            aircrafts2.get(i).setId(i);
            i++;
        }
    }

    @Test
    public void showAllTest() {

        for(int i = 0; i < aircrafts.size(); i++) {
            assertEquals(aircrafts.get(i).getFuelConsumption(), aircrafts2.get(i).getFuelConsumption());
            assertEquals(aircrafts.get(i).getTypeId(), aircrafts2.get(i).getTypeId());
            assertEquals(aircrafts.get(i).getId(), aircrafts2.get(i).getId());
            assertEquals(aircrafts.get(i).getName(), aircrafts2.get(i).getName());
            assertEquals(aircrafts.get(i).getFlightRange(), aircrafts2.get(i).getFlightRange());
            assertEquals(aircrafts.get(i).getCarriageCapacity(), aircrafts2.get(i).getCarriageCapacity());
        }

        when(aircraftsDao.readAllAircrafts()).thenReturn(aircrafts);
        aircrafts = showAllAircraftsService.showAll();
        for(int i = 0; i < aircrafts.size(); i++) {
            assertEquals(aircrafts.get(i).getId(), aircrafts2.get(i).getId());
            assertEquals(aircrafts.get(i).getName(), aircrafts2.get(i).getName());
            assertEquals(aircrafts.get(i).getFlightRange(), aircrafts2.get(i).getFlightRange());
            assertEquals(aircrafts.get(i).getCarriageCapacity(), aircrafts2.get(i).getCarriageCapacity());
        }

    }
}

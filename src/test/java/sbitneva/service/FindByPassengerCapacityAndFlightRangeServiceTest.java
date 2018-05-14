package sbitneva.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sbitneva.dao.sqlite.AircraftsDao;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FindByPassengerCapacityAndFlightRangeServiceTest {

    @InjectMocks
    private FindByPassengerCapacityAndFlightRangeService findByPassengerCapacityAndFlightRangeService;

    @Mock
    private AircraftsDao aircraftsDao;

    @Test
    public void findTest(){
        findByPassengerCapacityAndFlightRangeService.find(1000, 6000);
        verify(aircraftsDao, times(1)).findByPassengerCapacityAndFlightRange(anyInt(), anyInt());
    }
}

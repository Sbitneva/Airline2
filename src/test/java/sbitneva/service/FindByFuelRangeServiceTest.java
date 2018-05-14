package sbitneva.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import sbitneva.dao.sqlite.AircraftsDao;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FindByFuelRangeServiceTest {

    @Autowired
    @InjectMocks
    private FindByFuelRangeService findByFuelRangeService;

    @Autowired
    @Mock
    private AircraftsDao aircraftsDao;

    @Test
    public void findTest(){
        findByFuelRangeService.findInRange(4000, 5000);
        verify(aircraftsDao, times(1)).findByFuelRange(anyInt(), anyInt());
    }
}

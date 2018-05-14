package sbitneva.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import sbitneva.dao.sqlite.BaggageDao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CalcCapacitiesServiceTest {

    @Autowired
    @InjectMocks
    CalcCapacitiesService calcCapacitiesService;

    @Autowired
    @Mock
    BaggageDao baggageDao;

    @Test
    public void calcTest() {
        calcCapacitiesService.calc();
        verify(baggageDao, times(1)).calcCapacity();
    }
}

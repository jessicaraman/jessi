package fr.digicar.backoffice.service;

import fr.digicar.dao.DelayDAO;
import fr.digicar.model.Delay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DelayServiceImplTest {

    @Mock
    private DelayDAO delayDAO;

    @InjectMocks
    private DelayServiceImpl delayService;

    @Test
    public void getDelayNumberReturnsCorrectValue() {
        when(delayDAO.count()).thenReturn(1000);

        assertEquals(1000, delayService.getDelayNumber());
    }

    @Test
    public void getDelayDistributionReturnCoherentResult() {
        List<Delay> delays = new ArrayList<>();
        delays.add(new Delay(1, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(2, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(3, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(4, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(5, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(6, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(7, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(8, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(9, (int)(Math.random()*100), new Date()));
        delays.add(new Delay(10, (int)(Math.random()*100), new Date()));

        when(delayDAO.findAll()).thenReturn(delays);

        int total = 0;
        for (int delayNumber : delayService.getDelayDistribution()) {
            total += delayNumber;
        }
        assertEquals(10, total);
    }

    @Test
    public void getDelayValuesReturnsSortedDurationArray() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getDelayValues", List.class);
        method.setAccessible(true);

        List<Delay> delays = new ArrayList<>();
        delays.add(new Delay(1, 3, new Date()));
        delays.add(new Delay(2, 6, new Date()));
        delays.add(new Delay(3, 2, new Date()));
        delays.add(new Delay(4, 7, new Date()));

        assertArrayEquals(new int[]{2, 3, 6, 7}, (int[]) method.invoke(delayService, delays));
    }

}
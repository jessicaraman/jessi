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

    private Date dateStart = new Date(1514764800000L);
    private Date dateEnd = new Date(1546300799000L);

    @Test
    public void getDelayNumberReturnsCorrectValue() {
        when(delayDAO.countByDate(dateStart, dateEnd)).thenReturn(1000);

        assertEquals(1000, delayService.getDelayNumber(dateStart, dateEnd, false));
    }

    @Test
    public void getDelayDistributionReturnCoherentResult() {
        List<Delay> delays = new ArrayList<>();
        delays.add(new Delay(1, (int) (Math.random() * 100), new Date(1514764800000L)));
        delays.add(new Delay(2, (int) (Math.random() * 100), new Date(1517443200000L)));
        delays.add(new Delay(3, (int) (Math.random() * 100), new Date(1519862400000L)));
        delays.add(new Delay(4, (int) (Math.random() * 100), new Date(1522540800000L)));
        delays.add(new Delay(5, (int) (Math.random() * 100), new Date(1525132800000L)));
        delays.add(new Delay(6, (int) (Math.random() * 100), new Date(1527811200000L)));
        delays.add(new Delay(7, (int) (Math.random() * 100), new Date(1530403200000L)));
        delays.add(new Delay(8, (int) (Math.random() * 100), new Date(1533081600000L)));
        delays.add(new Delay(9, (int) (Math.random() * 100), new Date(1535760000000L)));
        delays.add(new Delay(10, (int) (Math.random() * 100), new Date(1538352000000L)));

        when(delayDAO.filterByDate(dateStart, dateEnd)).thenReturn(delays);

        int total = 0;
        for (int delayNumber : delayService.getDelayDistribution(dateStart, dateEnd, false).getValues()) {
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

    @Test
    public void getQuartileReturnCorrectNumber() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getQuartile", int[].class, int.class);
        method.setAccessible(true);

        int[] delayValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(3, (int) method.invoke(delayService, delayValues, 25));
        assertEquals(6, (int) method.invoke(delayService, delayValues, 50));
        assertEquals(8, (int) method.invoke(delayService, delayValues, 75));
    }

    @Test
    public void getQuartileLabelsReturnsStringArray() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException  {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getQuartileLabels", int[].class);
        method.setAccessible(true);

        int[] quartiles = new int[]{1, 3, 6, 8, 10};
        String[] expected = new String[]{"1-3 min.", "4-6 min.", "7-8 min.", "9-10 min."};

        assertArrayEquals(expected, (String[]) method.invoke(delayService, (Object) quartiles));
    }

    @Test
    public void getMeanReturnsCorrectValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getMean", int[].class);
        method.setAccessible(true);

        int[] values = new int[]{4, 4, 6, 6, 3, 3, 7, 7, 2, 8};
        assertEquals(5, (double) method.invoke(delayService, (Object) values), 0);
    }

    @Test
    public void getVarianceReturnsCorrectValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getVariance", int[].class);
        method.setAccessible(true);

        int[] values = new int[]{17, 15, 23, 7, 9, 13};
        assertEquals(33.2, (double) method.invoke(delayService, (Object) values), 0);
    }

    @Test
    public void getStandardDeviationCorrectValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = DelayServiceImpl.class.getDeclaredMethod("getStandardDeviation", int[].class);
        method.setAccessible(true);

        int[] values = new int[]{17, 15, 23, 7, 9, 13};
        assertEquals(5.76, (double) method.invoke(delayService, (Object) values), 0.002);
    }

}
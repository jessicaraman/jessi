package fr.digicar.backoffice.service;

import fr.digicar.dao.DelayDAO;
import fr.digicar.model.Delay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
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
    public void getDelayNumber() {
        List<Delay> delays = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            delays.add(new Delay());
        }
        when(delayDAO.findAll()).thenReturn(delays);

        assertEquals(1000, delayService.getDelayNumber());
    }
}
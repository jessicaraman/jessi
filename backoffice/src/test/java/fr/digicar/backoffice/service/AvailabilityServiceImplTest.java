package fr.digicar.backoffice.service;

import fr.digicar.dao.AvailabilityDAO;
import fr.digicar.model.Availability;
import fr.digicar.backoffice.service.AvailabilityServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


public class AvailabilityServiceImplTest {

    @Mock
    private AvailabilityDAO availabilityDAO;

    @InjectMocks
    private AvailabilityServiceImpl availabilityService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listAllAvailabilitiesShouldReturnAllAvailabilities(){

        List<Availability> availabilities = new ArrayList<>();
        availabilities.add(new Availability(1,"01-01-2018",1, "12:00", "12:10",false));
        availabilities.add(new Availability(1,"01-02-2018",2, "12:10", "12:20",true));
        availabilities.add(new Availability(1,"01-03-2018",3, "12:20", "12:30",true));
        availabilities.add(new Availability(1,"12-03-2018",4, "13:00", "13:10",false));
        Mockito.when(availabilityDAO.getAllAvailability()).thenReturn(availabilities);

        List<Availability> availabilityListTest = availabilityService.getAllAvailability();

        Assert.assertEquals(availabilities, availabilityListTest);
    }

}

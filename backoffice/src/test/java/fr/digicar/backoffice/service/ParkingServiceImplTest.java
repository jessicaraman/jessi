package fr.digicar.backoffice.service;

import fr.digicar.dao.CarAvailabilityDAO;
import fr.digicar.dao.ParkingDAO;
import fr.digicar.model.CarAvailability;
import fr.digicar.model.Parking;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barry on 12/05/2018.
 */

@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingServiceImplTest {

    @Mock
    private ParkingDAO parkingDAO;

    @InjectMocks
    private ParkingServiceImpl parkingService;


    /**
     * Unit test for getAllParkings method
     * from ParkingServiceImpl class
     */
    @Test
    public void listAllCarParkingsShouldReturnAllParkings() {
        //
        //GIVEN
        //
        List<Parking> parkings = new ArrayList<>();
        parkings.add(new Parking(1, "1","26 Arizona Park"));
        parkings.add(new Parking(2, "2","1 Darwin Terrace"));
        parkings.add(new Parking(3, "3","19 Carioca Plaza"));
        parkings.add(new Parking(4, "4","8999 Loftsgordon Hill"));
        parkings.add(new Parking(5, "5","3 Stuart Way"));

        Mockito.when(parkingDAO.getAllParkings()).thenReturn(parkings);
        //
        //WHEN
        //
        List<Parking> parkingsListTest = parkingService.getAllParkings();
        //
        //THEN
        //
        Assert.assertEquals(parkings, parkingsListTest);
    }
}

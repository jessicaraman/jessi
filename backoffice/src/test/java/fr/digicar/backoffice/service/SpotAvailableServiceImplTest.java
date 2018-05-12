package fr.digicar.backoffice.service;

import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.dao.SpotAvailableDAO;
import fr.digicar.model.ParkingSpot;
import fr.digicar.model.SpotAvailable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class SpotAvailableServiceImplTest {

    @Mock
    private SpotAvailableDAO spotAvailableDAO;

    @InjectMocks
    private SpotAvailableServiceImpl spotAvailableService;


    /**
     * Unit test for getAllSpotsAvailable method
     * from SpotAvailableServiceImpl class
     */
    @Test
    public void listAllSpotsAvailableShouldReturnAllSpotsAvailable() {
        //
        //GIVEN
        //
        List<SpotAvailable> spotNotAvailables = new ArrayList<>();
        spotNotAvailables.add(new SpotAvailable(11, "no"));
        spotNotAvailables.add(new SpotAvailable(21, "no"));
        spotNotAvailables.add(new SpotAvailable(31,"no"));
        spotNotAvailables.add(new SpotAvailable(41, "no"));

        List<SpotAvailable> spotAvailables = new ArrayList<>();
        spotAvailables.add(new SpotAvailable(1, "yes"));
        spotAvailables.add(new SpotAvailable(2, "yes"));
        spotAvailables.add(new SpotAvailable(3,"yes"));
        spotAvailables.add(new SpotAvailable(4, "yes"));
        spotAvailables.add(new SpotAvailable(5, "yes"));
        spotAvailables.add(new SpotAvailable(6, "yes"));
        spotAvailables.add(new SpotAvailable(7, "yes"));
        //
        //WHEN
        //
        Mockito.when(spotAvailableDAO.getAllSpotsAvailable()).thenReturn(spotAvailables);

        List<SpotAvailable> spotAvailablesListTest = spotAvailableService.getAllSpotsAvailable();
        //
        //THEN
        //
        Assert.assertEquals(spotAvailables, spotAvailablesListTest);
    }


}

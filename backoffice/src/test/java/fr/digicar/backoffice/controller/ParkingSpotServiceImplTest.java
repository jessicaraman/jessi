package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.ParkingSpotServiceImpl;
import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.model.ParkingSpot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSpotServiceImplTest {

    @Mock
    private ParkingSpotDAO parkingSpotDAO;

    @InjectMocks
    private ParkingSpotServiceImpl parkingSpotService;

    @Test
    public void listAllParkingSpotsShouldReturnAllParkingSpots() {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new ParkingSpot(1, 1, "12", true, "location", 1, 1, 1, 1));
        parkingSpots.add(new ParkingSpot(2, 2, "12", false, "location", 2, 1, 3, 1));
        parkingSpots.add(new ParkingSpot(3, 1, "14", true, "location2", 1, 1, 1, 1));
        parkingSpots.add(new ParkingSpot(4, 3, "15", false, "location3", 3, 3, 1, 1));
        Mockito.when(parkingSpotDAO.getParkingSpots()).thenReturn(parkingSpots);

         List<ParkingSpot> parkingSpotListTest = parkingSpotService.getParkingSpots();

        Assert.assertEquals(parkingSpots, parkingSpotListTest);
    }


}

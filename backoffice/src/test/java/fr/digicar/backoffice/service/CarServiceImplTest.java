package fr.digicar.backoffice.service;

import fr.digicar.dao.CarDAO;
import fr.digicar.model.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class CarServiceImplTest {

    @Mock
    private CarDAO carDAO;

    @InjectMocks
    private CarServiceImpl carService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCarShouldReturnCarRegistered() {
        //
        //GIVEN
        //
        Car expectedCar = new Car();
        expectedCar.setId(1);
        expectedCar.setComfort(5);
        expectedCar.setFuel_type(1);
        expectedCar.setKilometers(5);
        expectedCar.setMark("MAZDA");
        expectedCar.setName_model("MAZDA3");
        expectedCar.setNb_doors(5);
        expectedCar.setNb_places(5);
        expectedCar.setRegistration_number("IA123AA");
        expectedCar.setRelease_date("2018-01-22");
        expectedCar.setType(4);
        when(carService.getCarById(expectedCar.getId())).thenReturn(expectedCar);

        carDAO.addCar(expectedCar);

        //
        //WHEN
        //
        Car actualCar = carService.getCarById(1);

        //
        //THEN
        //
        Assert.assertEquals(expectedCar, actualCar);
        Assert.assertEquals(expectedCar.hashCode(), actualCar.hashCode());
        Assert.assertEquals(expectedCar.toString(), actualCar.toString());

    }
}
package fr.digicar.backoffice.service;


import fr.digicar.dao.CarDAO;
import fr.digicar.init.WebAppConfig;
import fr.digicar.model.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
@WebAppConfiguration

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
    public void getCarShiulReturnCarRegistred(){
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
        expectedCar.setTransmission(1);
        when(carService.getCar(expectedCar.getId())).thenReturn(expectedCar);


        carDAO.addCar(expectedCar);

        //
        //WHEN
        //
        Car actualCar = carService.getCar(1);

        //
        //THEN
        //
        Assert.assertEquals(expectedCar, actualCar);
        Assert.assertEquals(expectedCar.hashCode(), actualCar.hashCode());
        Assert.assertEquals(expectedCar.toString(), actualCar.toString());

    }
}
package fr.digicar.backoffice.service;

import fr.digicar.backoffice.service.CarServiceImpl;
import fr.digicar.dao.CarDAO;
import fr.digicar.model.Car;
import fr.digicar.init.WebAppConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

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
    public void itShoulDReturnCarRegistred(){
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

    /**
     *  Unit test for getAllCars method
     *  from carServiceImpl class
     */
    @Test
    public void getAllCarsShouldReturnAllCars(){
        //
        // GIVEN
        //
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "BA-961-VC", "audi", "a1", 1, 2, 3, 1, 50100, "2009-02-25", 4, 2));
        carList.add(new Car(2, "PN-341-KL", "audi", "a6", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3));
        carList.add(new Car(3, "BD-525-MI", "audi", "a8", 2, 4, 5, 1, 50100, "2009-02-25", 4, 2));

        Mockito.when(carDAO.getAllCar()).thenReturn(carList);

        //
        // WHEN
        //
        List<Car> carListTest = carService.getAllCar();

        //
        // THEN
        //
        Assert.assertEquals(carList, carListTest);
    }

    /**
     *  Unit test for getCarByRegistration method
     *  from carServiceImpl class
     */
    @Test
    public void getCarByRegistrationShouldReturnSpecificCar(){
        //
        // GIVEN
        //
        Car exceptedCar = new Car(2, "PN-341-KL", "audi", "a6", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3);

        Mockito.when(carDAO.getCarByRegistration("PN-341-KL")).thenReturn(exceptedCar);

        //
        // WHEN
        //
        Car carTest = carService.getCarByRegistration("PN-341-KL");

        //
        // THEN
        //
        Assert.assertEquals(exceptedCar, carTest);
    }

    /**
     *  Unit test for getCarByRegistration method
     *  from carServiceImpl class
     */
    @Test
    public void getCarByRegistrationWithUnknowRegistrationNumberShouldReturnNothing(){
        //
        // GIVEN
        //
        Car fakeExceptedCar = new Car(2, "PN-341-KL", "audi", "a6", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3);

        Mockito.when(carDAO.getCarByRegistration("PN-341-KL")).thenReturn(fakeExceptedCar);

        //
        // WHEN
        //
        Car carTest = carService.getCarByRegistration("BA-346-PC");

        //
        // THEN
        //
        Assert.assertEquals(null, carTest);
    }

    /**
     *  Unit test for carByCriteria method
     *  from carServiceImpl class
     */
    @Test
    public void carByCriteriaShouldReturnSpecificCars(){
        //
        // GIVEN
        //
        List<Car> exceptedCarList = new ArrayList<>();
        exceptedCarList.add(new Car(1, "BA-961-VC", "audi", "a1", 1, 2, 3, 1, 50100, "2009-02-25", 4, 2));
        exceptedCarList.add(new Car(2, "PN-341-KL", "audi", "a1", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3));
        exceptedCarList.add(new Car(3, "BD-525-MI", "audi", "a1", 2, 4, 5, 1, 50100, "2009-02-25", 4, 2));


        Mockito.when(carDAO.CarByCriteria("audi","a1", null, null, null, null, null)).thenReturn(exceptedCarList);

        //
        // WHEN
        //
        List<Car> carListTest = carService.CarByCriteria("audi","a1", null, null, null, null, null);

        //
        // THEN
        //
        Assert.assertEquals(exceptedCarList, carListTest);
    }

    /**
     *  Unit test for carByCriteria method
     *  from carServiceImpl class
     */
    @Test
    public void carByCriteriaShouldReturnNothingWhenCriteriaNotMatch(){
        //
        // GIVEN
        //
        List<Car> fakeExceptedCarList = new ArrayList<>();
        fakeExceptedCarList.add(new Car(1, "BA-961-VC", "audi", "a1", 1, 2, 3, 1, 50100, "2009-02-25", 4, 2));
        fakeExceptedCarList.add(new Car(2, "PN-341-KL", "audi", "a1", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3));
        fakeExceptedCarList.add(new Car(3, "BD-525-MI", "audi", "a1", 2, 4, 5, 1, 50100, "2009-02-25", 4, 2));


        Mockito.when(carDAO.CarByCriteria("audi","a1", null, null, null, null, null)).thenReturn(fakeExceptedCarList);

        //
        // WHEN
        //
        List<Car> carListTest = carService.CarByCriteria("audi","a5", null, null, null, null, null);

        //
        // THEN
        //
        Assert.assertEquals(new ArrayList<>(), carListTest);
    }

    /**
     *  Unit test for carByCriteria method
     *  from carServiceImpl class
     */
    @Test
    public void carByCriteriaShouldReturnOneCarWhenCriteriaMatchOnOneCar(){
        //
        // GIVEN
        //
        List<Car> exceptedCarList = new ArrayList<>();
        exceptedCarList.add(new Car(2, "PN-341-KL", "audi", "a8", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3));

        List<Car> fakeExceptedCarList = new ArrayList<>();
        fakeExceptedCarList.add(new Car(1, "BA-961-VC", "audi", "a1", 1, 2, 3, 1, 50100, "2009-02-25", 4, 2));
        fakeExceptedCarList.add(new Car(2, "PN-341-KL", "audi", "a8", 2, 4, 5, 1, 40000, "20012-01-14", 5, 3));
        fakeExceptedCarList.add(new Car(3, "BD-525-MI", "audi", "a1", 2, 4, 5, 1, 150100, "2009-02-25", 4, 2));

        Mockito.when(carDAO.CarByCriteria("audi","a1", null, null, null, null, null)).thenReturn(fakeExceptedCarList);
        Mockito.when(carDAO.CarByCriteria("audi","a8", null, null, null, "30000", "45000")).thenReturn(exceptedCarList);


        //
        // WHEN
        //
        List<Car> carListTest = carService.CarByCriteria("audi","a8", null, null, null, "30000", "45000");

        //
        // THEN
        //
        Assert.assertEquals(exceptedCarList, carListTest);
    }


}
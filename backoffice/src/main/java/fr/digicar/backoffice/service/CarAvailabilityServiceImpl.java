package fr.digicar.backoffice.service;

import fr.digicar.dao.*;
import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import fr.digicar.model.ParkingSpot;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.ReservationOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Service
@Transactional
public class CarAvailabilityServiceImpl implements CarAvailabilityService{

    @Autowired
    private CarAvailabilityDAO carAvailabilityDAO;

    @Autowired
    private CarService carService;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private CarTypeDAO carTypeDAO;

    @Autowired
    private CarDAO carDAO;

    @Transactional
    @Override
    public CarAvailability getCarAvailabilityByCriteria(String available) {
        return carAvailabilityDAO.getCarAvailabilityByCriteria(available);
    }

    @Transactional
    @Override
    public List<CarAvailability> getAllCarAvailabilities() {
        return carAvailabilityDAO.getAllCarAvailabilities();
    }

    @Override
    public List<ReservationOdt> getCarAvailabilityBy(final FilterBookingOdt filters){

        String date = filters.getWishedDate();
        log.info("Date input: " + date);
        String startTime = filters.getStartTime();
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime();
        log.info("endTime input: " + endTime);
        String city = filters.getCity();
        log.info("city input: " + city);
        int idCarType = Integer.parseInt(filters.getCarType());
        log.info("idCarType input: " + idCarType);

        List<CarAvailability> listOfCarAvailable = carAvailabilityDAO.getAllCarAvailabilities();
        List<CarAvailability> carsAvailable = new ArrayList<>();
        List<ReservationOdt> potentialBooking = new ArrayList<>();

        log.info("Size of carsAvailable : " + carsAvailable.size());

        for (CarAvailability carAvailable : listOfCarAvailable) {
            if (carDAO.getCarById(carAvailable.getId_car()).getType() != idCarType
                    || !(parkingSpotDAO.getParkingSpot(carAvailable.getId_parking_spots()).getLocation().equals(city))) {

                Car car = carService.getCarById(carAvailable.getId_car());
                ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(carAvailable.getId_parking_spots());
                String mark = car.getBrandName();
                log.info("mark: " + mark);
                String model = car.getModelName();
                log.info("model: " + model);
                int doorsNumber = car.getDoorNumber();
                log.info("doorsNumber: " + doorsNumber);
                String parkingAddress = (parkingService.getParkingById(Integer.parseInt(parkingSpot.getNbParking()))).getRoad_name();

                potentialBooking.add(new ReservationOdt(mark, model, doorsNumber, parkingAddress));

            }
        }
        return  potentialBooking;
    }

}

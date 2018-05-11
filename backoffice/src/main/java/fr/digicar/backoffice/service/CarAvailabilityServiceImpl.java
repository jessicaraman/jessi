package fr.digicar.backoffice.service;

import fr.digicar.dao.*;
import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import fr.digicar.model.ParkingSpot;
import fr.digicar.model.ReservationPrices;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.ReservationOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ReservationPricesService reservationPricesService;

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

        String startCity = filters.getStartCity();
        log.info("Date input: " + startCity);
        String startTime = filters.getStartTime()+":00";
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime()+":00";
        log.info("endTime input: " + endTime);
        String arrivedCity = filters.getArrivedCity();
        log.info("arrivedCity input: " + arrivedCity);
        int idCarType = Integer.parseInt(filters.getCarType());
        log.info("idCarType input: " + idCarType);

        /* calculate booking duration */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        startTime = startTime.replace("T"," ");
        endTime = endTime.replace("T"," ");

        Double durationInMinute = (double) -1;

        Date dateStart = null;
        Date dateEnd = null;

        try {
            dateStart = sdf.parse(startTime);
            dateEnd = sdf.parse(endTime);

            //in milliseconds
            durationInMinute = (double) (dateEnd.getTime() - dateStart.getTime());
            //in minutes
            durationInMinute = (durationInMinute/1000)/60;

        } catch (Exception e) {
            e.printStackTrace();

        }


        List<CarAvailability> listOfCarAvailable = carAvailabilityDAO.getAllCarAvailabilities();
        List<CarAvailability> carsAvailable = new ArrayList<>();
        List<ReservationOdt> potentialBooking = new ArrayList<>();

        log.info("Size of carsAvailable : " + carsAvailable.size());

        for (CarAvailability carAvailable : listOfCarAvailable) {
            if (carDAO.getCarById(carAvailable.getId_car()).getType() != idCarType
                    || !(parkingSpotDAO.getParkingSpot(carAvailable.getId_parking_spots()).getLocation().equals(arrivedCity))) {

                Car car = carService.getCarById(carAvailable.getId_car());
                ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(carAvailable.getId_parking_spots());
                String mark = car.getBrandName();
                log.info("mark: " + mark);
                String model = car.getModelName();
                log.info("model: " + model);
                int doorsNumber = car.getDoorNumber();
                log.info("doorsNumber: " + doorsNumber);
                String parkingAddress = (parkingService.getParkingById(Integer.parseInt(parkingSpot.getNbParking()))).getRoad_name();
                log.info("parkingAddress: " + parkingAddress);
                ReservationPrices  reservationPrices = reservationPricesService.getReservationPriceByCriterias(car.getType(), car.getFuelType());
                Double price = reservationPrices.getPricing_minute_standard() * durationInMinute ;

                potentialBooking.add(new ReservationOdt(mark, model, doorsNumber, parkingAddress, price));

            }
        }
        return  potentialBooking;
    }

}

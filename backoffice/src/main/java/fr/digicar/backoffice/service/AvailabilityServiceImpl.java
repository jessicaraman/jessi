package fr.digicar.backoffice.service;

import fr.digicar.dao.AvailabilityDAO;
import fr.digicar.model.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityDAO availabilityDAO;

    @Override
    public Availability getAvailabilityById(int id_availability){
        return availabilityDAO.getAvailabilityById(id_availability);
    }

    @Override
    public List<Availability> getAllAvailability(){
        return availabilityDAO.getAllAvailability();
    }

    @Override
    public List<Availability> availabilityByCreteria(String date, String start_time, String end_time){
        return availabilityDAO.availabilityByCriteria(date, start_time, end_time);
    }
}

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
    public Availability getAvailabilityById(int idAvailability){
        return availabilityDAO.getAvailabilityById(idAvailability);
    }

    @Override
    public List<Availability> getAllAvailability(){
        return availabilityDAO.getAllAvailability();
    }

    @Override
    public List<Availability> availabilityByCriteria(String date, String startTime, String endTime){
        return availabilityDAO.availabilityByCriteria(date, startTime, endTime);
    }
}

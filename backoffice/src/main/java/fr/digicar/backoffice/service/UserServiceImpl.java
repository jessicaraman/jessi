package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.SearchCriteria;
import fr.digicar.dao.UserDAO;
import fr.digicar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> searchUsers() {
        return userDAO.getUsers();
    }

    @Override
    public List<User> searchUsers(SearchCriteria searchCriteria) {
        if (searchCriteria != null) {
            return userDAO.filterUsers(generateSearchString(searchCriteria));
        }
        return searchUsers();
    }

    String generateSearchString(SearchCriteria searchCriteria) {
        String searchString = "from User where ";
        String byNameString = "";
        String byDepartmentsString = "";
        String byStatusesString = "";
        if (searchCriteria.getName() != null && searchCriteria.getName().length() > 0) {
            byNameString = "firstName like \'%" + searchCriteria.getName() + "%\' or lastName like \'%" + searchCriteria.getName() + "%\'";
        }
        if (searchCriteria.getDepartments() != null && searchCriteria.getDepartments().length > 0) {
            int i = 0;
            do {
                byDepartmentsString += i > 0 ? " or " : "";
                byDepartmentsString += "zipCode like \'" + searchCriteria.getDepartments()[i] + "%\'";
                i++;
            } while (i < searchCriteria.getDepartments().length);
        }
        if (searchCriteria.getStatuses() != null && searchCriteria.getStatuses().length > 0) {
            int i = 0;
            do {
                byStatusesString += i > 0 ? " or " : "";
                byStatusesString += "status = \'" + searchCriteria.getStatuses()[i] + "\'";
                i++;
            } while (i < searchCriteria.getStatuses().length);
        }
        searchString += byNameString.length() > 0 ? byNameString : "";
        searchString += byNameString.length() > 0 && (byDepartmentsString.length() > 0 || byStatusesString.length() > 0) ? " and " : "";
        searchString += byDepartmentsString.length() > 0 ? byDepartmentsString : "";
        searchString += (byNameString.length() > 0 || byDepartmentsString.length() > 0) && byStatusesString.length() > 0 ?  " and " : "";
        searchString += byStatusesString.length() > 0 ? byStatusesString : "";
        return searchString;
    }

}

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
        if (searchCriteria != null
                && ((searchCriteria.getName() != null && searchCriteria.getName().length() > 0)
                || searchCriteria.getDepartments().length > 0
                || searchCriteria.getStatuses().length > 0)) {
            return userDAO.filterUsers(generateSearchString(searchCriteria));
        }
        return searchUsers();
    }

    String generateSearchString(SearchCriteria searchCriteria) {
        String searchString = "from User where ";
        String byNameString = "";
        StringBuilder byDepartmentsString = new StringBuilder();
        StringBuilder byStatusesString = new StringBuilder();
        if (searchCriteria.getName() != null && searchCriteria.getName().length() > 0) {
            byNameString = "(firstName like \'%" + searchCriteria.getName() + "%\' or lastName like \'%" + searchCriteria.getName() + "%\')";
        }
        if (searchCriteria.getDepartments() != null && searchCriteria.getDepartments().length > 0) {
            byDepartmentsString.append("(");
            int i = 0;
            do {
                byDepartmentsString.append(i > 0 ? " or " : "");
                byDepartmentsString.append("zipCode like \'").append(searchCriteria.getDepartments()[i]).append("%\'");
                i++;
            } while (i < searchCriteria.getDepartments().length);
            byDepartmentsString.append(")");
        }
        if (searchCriteria.getStatuses() != null && searchCriteria.getStatuses().length > 0) {
            byStatusesString.append("(");
            int i = 0;
            do {
                byStatusesString.append(i > 0 ? " or " : "");
                byStatusesString.append("status = \'").append(searchCriteria.getStatuses()[i]).append("\'");
                i++;
            } while (i < searchCriteria.getStatuses().length);
            byStatusesString.append(")");
        }
        searchString += byNameString.length() > 0 ? byNameString : "";
        searchString += byNameString.length() > 0 && (byDepartmentsString.length() > 0 || byStatusesString.length() > 0) ? " and " : "";
        searchString += byDepartmentsString.length() > 0 ? byDepartmentsString.toString() : "";
        searchString += byDepartmentsString.length() > 0 && byStatusesString.length() > 0 ? " and " : "";
        searchString += byStatusesString.length() > 0 ? byStatusesString.toString() : "";
        return searchString;
    }

}

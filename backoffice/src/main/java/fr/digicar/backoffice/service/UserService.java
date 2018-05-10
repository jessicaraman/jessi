package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.SearchCriteria;
import fr.digicar.model.User;

import java.util.List;

public interface UserService {

    List<User> searchUsers();

    List<User> searchUsers(SearchCriteria searchCriteria);
    User getUser(int id);
    void updateGestureAccountUser(int id);

}

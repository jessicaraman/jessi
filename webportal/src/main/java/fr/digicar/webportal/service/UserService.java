package fr.digicar.webportal.service;

import fr.digicar.model.User;

public interface UserService {

    void createUser(User team);

    void updateUser(User team);

    User getUser(int id);

    void deleteUser(int id);

}

package fr.digicar.dao;

import fr.digicar.model.User;

public interface UserDAO {

    void addUser(User team);

    void updateUser(User team);

    User getUser(int id);

    void deleteUser(int id);

    boolean checkEmailExistence(String email);

    boolean checkUserCredentials(User user);

}

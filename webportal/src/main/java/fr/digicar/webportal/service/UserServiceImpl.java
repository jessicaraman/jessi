package fr.digicar.webportal.service;

import fr.digicar.dao.UserDAO;
import fr.digicar.model.User;
import fr.digicar.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void createUser(User user) {
        user.setSignUpDate(new Date());
        user.setStatus(UserStatus.INACTIVE);
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public boolean checkEmailExistence(String email) {
        return userDAO.checkEmailExistence(email);
    }

    @Override
    public boolean checkUserCredentials(User user) {
        return userDAO.checkUserCredentials(user);
    }

}

package fr.digicar.backoffice.service;

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
        return userDAO.searchUsers();
    }

}

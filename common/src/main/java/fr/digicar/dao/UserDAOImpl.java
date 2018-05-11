package fr.digicar.dao;

import fr.digicar.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        // TODO complete update user.
        getCurrentSession().update(userToUpdate);
    }

    @Override
    public User getUser(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void updateGestureAccountUser(int id) {
        User user = getUser(id);
        user.setNumberOfCommercialGesture(user.getNumberOfCommercialGesture()+1);
        getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        try {
            return getCurrentSession().createQuery("FROM User").list();
        } catch (ClassCastException e) {
            return new ArrayList<>();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> filterUsers(String searchQuery) {
        try {
            return getCurrentSession().createQuery(searchQuery).list();
        } catch (ClassCastException e) {
            return new ArrayList<>();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean checkEmailExistence(String email) {
        Query query = getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setString("email", email);
        List<User> result;
        try {
            result = (List<User>) query.list();
        } catch (ClassCastException e) {
            result = new ArrayList<>();
        }
        return !(result.size() > 0);
    }

    @Override
    public boolean checkUserCredentials(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User user1 = (User) getCurrentSession().get(User.class, email);
        User user2 = (User) getCurrentSession().get(User.class, password);
        return user1 != null && user1 == user2;
    }

}

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

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        // TODO complete update user.
        getCurrentSession().update(userToUpdate);
    }

    public User getUser(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    public List<User> getUsers() {
        try {
            return getCurrentSession().createQuery("from User").list();
        } catch (ClassCastException e) {
            return new ArrayList<User>();
        }
    }

    public List<User> filterUsers(String searchQuery) {
        try {
            return getCurrentSession().createQuery(searchQuery).list();
        } catch (ClassCastException e) {
            return new ArrayList<User>();
        }
    }

    public boolean checkEmailExistence(String email) {
        Query query = getCurrentSession().createQuery("from User where email = :email");
        query.setString("email", email);
        List<User> result;
        try {
            result = (List<User>) query.list();
        } catch (ClassCastException e) {
            result = new ArrayList<User>();
        }
        return !(result.size() > 0);
    }

    public boolean checkUserCredentials(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User user1 = (User) getCurrentSession().get(User.class, email);
        User user2 = (User) getCurrentSession().get(User.class, password);
        return user1 != null && user1 == user2;
    }

}

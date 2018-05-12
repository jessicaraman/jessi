package fr.digicar.dao;

import fr.digicar.model.Token;
import fr.digicar.model.Pricing;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository

public class TokenDAOImpl implements TokenDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Token getTokenByUserID(int id) {
        String hql ="From Token where id_user in("+id+")";
        return (Token) getCurrentSession().createQuery(hql).list().get(0);
    }

    @Override
    public void saveToken(Token t) {
        sessionFactory.getCurrentSession().update(t);
    }
}

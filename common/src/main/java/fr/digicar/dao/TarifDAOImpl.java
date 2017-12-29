package fr.digicar.dao;

import java.util.List;

import fr.digicar.model.Tarif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TarifDAOImpl implements TarifDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addTarif(Tarif tarif) {
        getCurrentSession().save(tarif);
    }
    public void updateTarif(Tarif tarif) {
        Tarif tarifToUpdate = getTarif(tarif.getId());
        //tarifToUpdate.setName(tarif.getName()); à redéfinir
        getCurrentSession().update(tarifToUpdate);

    }

    public Tarif getTarif(int id) {
        return (Tarif) getCurrentSession().get(Tarif.class, id);
    }

    public void deleteTarif(int id) {
        Tarif tarif = getTarif(id);
        if (tarif != null)
            getCurrentSession().delete(tarif);
    }

    @SuppressWarnings("unchecked")
    public List<Tarif> getTarifs() {
        return getCurrentSession().createQuery("from Tarif").list();
    }

}

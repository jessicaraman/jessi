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
        sessionFactory.getCurrentSession().save(tarif);

    }

    public void updateTarif(Tarif tarif) {
        sessionFactory.getCurrentSession().update(tarif);
    }

    public Tarif getTarif(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tarif t = (Tarif) session.load(Tarif.class, new Integer(id));
        return t;
    }

    public Tarif getTarifby(int id) {
        return (Tarif) getCurrentSession().get(Tarif.class, id);
    }

    public void deleteTarif(int id) {
        Tarif tarif = getTarif(id);
        if (tarif != null)
            getCurrentSession().delete(tarif);
    }


    @SuppressWarnings("unchecked")
    public List<Tarif> getTarifs() {
        return getCurrentSession().createQuery("FROM Tarif").list();
    }


    public List<Tarif> getTarifsByLibelle(String libelle){
        String sql ="FROM Tarif";
        if(libelle!="none"){ sql=sql+" where libelle ='"+libelle+"'";}
        return getCurrentSession().createQuery(sql).list();
    }

    public List<Tarif> searchTarifs(String libelle,float prix_km_min, float prix_km_max,
                                    float prix_heure_min,float prix_heure_max,int frais_mensuels_min, int frais_mensuels_max) {
        String sql ="FROM Tarif";
        if(libelle!="none"){ sql=sql+" where libelle ='"+libelle+"'";}
        else{
            sql=sql+" where prix_km>="+prix_km_min+" AND prix_km" + "<="+prix_km_max+
                    " and prix_heure>="+prix_heure_min+" and prix_heure<="+prix_heure_max+
                    " and frais_mensuels>= "+frais_mensuels_min+" and frais_mensuels<="+frais_mensuels_max;}
        System.out.println(sql);
        return getCurrentSession().createQuery(sql).list();
    }


}
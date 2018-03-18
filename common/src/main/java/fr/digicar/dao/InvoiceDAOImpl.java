package fr.digicar.dao;

import fr.digicar.model.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
    @Autowired

    private SessionFactory sessionFactory;
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addInvoice(Invoice inv) {
        getCurrentSession().save(inv);
    }

    public void updateInvoice(Invoice inv) {

    }

    public Invoice getInvoice(int invoiceId) {
        return null;
    }

    public Invoice getInvoiceByUserAndDate(int userId, Date date) {
        return null;
    }

    public List<Invoice> getInvoices() {
        String sql ="FROM Invoice";
        System.out.println(sql);
        return getCurrentSession().createQuery(sql).list();
    }

    public List<Invoice> InvoiceByDate(Date d) {
        String sql ="FROM Invoice where date='"+d+"'";
        System.out.println(sql);
        return getCurrentSession().createQuery(sql).list();
    }
}

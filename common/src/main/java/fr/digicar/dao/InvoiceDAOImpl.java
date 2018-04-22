package fr.digicar.dao;

import fr.digicar.model.Invoice;
import org.hibernate.Query;
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

    @Override
    public void addInvoice(Invoice inv) {
        getCurrentSession().save(inv);
    }

    @Override
    public void updateInvoice(Invoice inv) {
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return null;
    }

    @Override
    public Invoice getInvoiceByUserAndDate(int userId, Date date) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoices() {
        return getCurrentSession().createQuery("FROM Invoice").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Invoice> invoiceByDate(Date date) {
        return getCurrentSession()
                .createQuery("FROM Invoice where date = :date")
                .setDate("date", date)
                .list();
    }
}

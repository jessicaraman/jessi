package fr.digicar.backoffice.service;

import fr.digicar.dao.InvoiceDAO;
import fr.digicar.dao.SubscriptionDAO;
import fr.digicar.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceDAO dao;
    @Override
    public void addInvoice(Invoice inv) {
        dao.addInvoice(inv);

    }

    @Override
    public void updateInvoice(Invoice inv) {
        dao.updateInvoice(inv);

    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return dao.getInvoice(invoiceId);
    }

    @Override
    public Invoice getInvoiceByUserAndDate(int userId, Date date) {
        return dao.getInvoiceByUserAndDate(userId,date);
    }

    @Override
    public List<Invoice> getInvoices() {
        return dao.getInvoices();
    }

    @Override
    public List<Invoice> InvoiceByDate(Date d) {
        return dao.InvoiceByDate(d);
    }
}

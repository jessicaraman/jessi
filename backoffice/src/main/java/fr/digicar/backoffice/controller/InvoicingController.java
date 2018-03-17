package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.InvoiceService;
import fr.digicar.backoffice.service.SubscriptionService;
import fr.digicar.backoffice.service.TarifService;
import fr.digicar.backoffice.service.UserService;
import fr.digicar.model.Invoice;
import fr.digicar.model.Subscription;
import fr.digicar.model.Tarif;
import fr.digicar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class InvoicingController {
    @Autowired
    SubscriptionService sub;
    @Autowired
    UserService u;
    @Autowired
    TarifService tarifService;
    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/invoices")
    public ModelAndView mainPageInvoices() {
        List<Subscription> t=sub.getSubscriptionByUserID();
        List<User> users =u.searchUsers();
        List<Tarif> tarifs =tarifService.getTarifs();
        List<Invoice> invoices = invoiceService.InvoiceByDate(convertUtilToSql(new Date()));
        ModelAndView modelAndView=new ModelAndView("usersinvoices");
       modelAndView.addObject("subscriptions",t);
       modelAndView.addObject("users",users);
       modelAndView.addObject("tarifs",tarifs);
       modelAndView.addObject("invoices",invoices);
        return modelAndView;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }


}

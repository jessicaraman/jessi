package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.SubscriptionService;
import fr.digicar.backoffice.service.TarifService;
import fr.digicar.backoffice.service.UserService;
import fr.digicar.model.Subscription;
import fr.digicar.model.Tarif;
import fr.digicar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InvoicingController {
    @Autowired
    SubscriptionService sub;

    @RequestMapping(value = "/invoices")
    public ModelAndView mainPageInvoices() {
        List<Subscription> t=sub.getSubscriptionByUserID(1);
        ModelAndView modelAndView=new ModelAndView("usersinvoices");
       // modelAndView.addObject("users",users);
        return modelAndView;
    }
}

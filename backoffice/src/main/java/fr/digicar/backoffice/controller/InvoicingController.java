package fr.digicar.backoffice.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import fr.digicar.backoffice.service.*;
import fr.digicar.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class InvoicingController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    @Autowired
    TarifService tarifService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    CarService carService;

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/invoices")
    public ModelAndView mainPageInvoices() {
        List<Subscription> t = subscriptionService.getSubscriptionByUserId();
        List<User> users = userService.searchUsers();
        List<Pricing> pricings = tarifService.getTarifs();
        List<Invoice> invoices = invoiceService.InvoiceByDate(convertUtilToSql(new Date()));
        String desktop = System.getProperty("user.home") + "/Desktop/";
        ModelAndView modelAndView = new ModelAndView("usersinvoices");
        modelAndView.addObject("subscriptions", t);
        modelAndView.addObject("users", users);
        modelAndView.addObject("tarifs", pricings);
        modelAndView.addObject("invoices", invoices);
        modelAndView.addObject("desktop", desktop);

        return modelAndView;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
    }

    @RequestMapping(value = "/algo")
    private ModelAndView testPDF() throws DocumentException, IOException {
        ModelAndView modelAndView = new ModelAndView("loader");
        Date today = new Date();
        List<Subscription> t = subscriptionService.getSubscriptionByUserId();
        List<User> users = userService.searchUsers();
        List<Pricing> pricing = tarifService.getTarifs();
        User currentUser = new User();
        Pricing tarif = new Pricing();
        for (Subscription inv : t) {
            for (User user : users) {
                if (inv.getUser() == user.getId()) {
                    currentUser = userService.getUser(user.getId());
                    tarif = tarifService.getTarif(inv.getPricing());
                }
            }
            List<Session> sessions = sessionService.getUserSessions(currentUser.getId(), today);
            double total = 0;
            String filename = convertUtilToSql(today) + "-" + currentUser.getLastName() + "-" + currentUser.getFirstName();
            String filepath = System.getProperty("user.home") + "/Desktop/" + filename + ".pdf";
            File file = new File(filepath);
            if (!file.exists()) {
                file.createNewFile();
            }
            log.debug("File exists: " + (file.exists() ? "true" : "false"));
            log.debug(file.getPath());
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            //Titre
            String title = "DIGICAR - FACTURE DU  " + formatDate(today);
            Chapter chapter = new Chapter(new Paragraph(), 1);
            chapter.setNumberDepth(0);
            String clin = "Numéro Client :" + currentUser.getId();
            String name = currentUser.getLastName() + " " + currentUser.getFirstName();
            String adress = currentUser.getAddressLine1() + " " + currentUser.getAddressLine2();
            String emailNNumber = currentUser.getPhoneNumber() + " - " + currentUser.getEmail();
            String zipNcity = currentUser.getCity() + " " + currentUser.getZipCode();
            String separator = "__________________________";
            //informations sur le Pricing
            String libelle_t = "Pricing " + tarif.getLabel() + " (depuis le " + formatDate(inv.getStartDate()) + ")";
            String prices = tarif.getHourlyPrice()
                    + " €/heure  "
                    + tarif.getKmPrice()
                    + " €/km  "
                    + tarif.getMonthlyFees()
                    + " €/mois  ";
            chapter.add(new Paragraph(title));
            chapter.add(new Paragraph(clin));
            chapter.add(new Paragraph(name));
            chapter.add(new Paragraph(adress));
            chapter.add(new Paragraph(zipNcity));
            chapter.add(new Paragraph(separator));
            chapter.add(new Paragraph(libelle_t));
            chapter.add(new Paragraph(prices));
            chapter.add(new Paragraph(separator));
            chapter.add(new Paragraph(separator));
            chapter.add(new Paragraph("Prestations consommées"));

            //creation Invoice
            Invoice invoice = new Invoice(currentUser.getId(), today, total, filepath.replace(System.getProperty("user.home") + "/Desktop/", ""));
            invoiceService.addInvoice(invoice);
            List<Session> sessionsOfTheMonth = sessionService.getUserSessions(currentUser.getId(), today);
            System.out.print(sessionsOfTheMonth.size());

            for (Session ses : sessionsOfTheMonth) {
                String dateOfsession = "Début " + formatDate(ses.getDepartureDate())
                        + " " + ses.getDepartureDate().getHours()
                        + "h" + ses.getDepartureDate().getMinutes()
                        + " / Fin " + formatDate(ses.getArrivalDate())
                        + " " + ses.getArrivalDate().getHours()
                        + "h" + ses.getArrivalDate().getMinutes();
                String duration = dureeSessionToString(ses.getDepartureDate(), ses.getArrivalDate());
                Car c = carService.getCarById(ses.getCar());
                String car = c.getBrandName() + " " + c.getModelName();
                String kms = "Km parcourus : " + ses.getKms();
                chapter.add(new Paragraph(dateOfsession));
                chapter.add(new Paragraph(duration));
                chapter.add(new Paragraph(car));
                chapter.add(new Paragraph(kms));
                chapter.add(new Paragraph(separator));
            }
            document.add(chapter);
            document.close();
        }
        return modelAndView;
    }

    private String formatDate(Date d) {
        SimpleDateFormat formater = new SimpleDateFormat("dd MMMMM yyyy");
        return formater.format(d);
    }

    public double dureeSession(Timestamp timestamp1, Timestamp timestamp2) {
        long milliseconds = timestamp2.getTime() - timestamp1.getTime();
        int seconds = (int) milliseconds / 1000;

        // calculate hours minutes and seconds
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;

        log.debug("timestamp1: " + timestamp1);
        log.debug("timestamp2: " + timestamp2);

        log.debug("Difference: ");
        log.debug(" Hours: " + hours);
        log.debug(" Minutes: " + minutes);
        log.debug(" Seconds: " + seconds);
        return hours + (minutes / 60);
    }

    private String dureeSessionToString(Timestamp timestamp1, Timestamp timestamp2) {
        long milliseconds = timestamp2.getTime() - timestamp1.getTime();
        int seconds = (int) milliseconds / 1000;

        // Calculate hours minutes and seconds
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;

        log.debug("timestamp1: " + timestamp1);
        log.debug("timestamp2: " + timestamp2);
        log.debug("Difference : " + hours + ":" + minutes + ":" + seconds);

        return hours + "h " + minutes + " minutes";
    }
}

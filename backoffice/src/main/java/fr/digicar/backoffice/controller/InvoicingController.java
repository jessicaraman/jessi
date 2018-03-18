package fr.digicar.backoffice.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import fr.digicar.backoffice.service.*;
import fr.digicar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    @Autowired
    CarService carService;
    @Autowired
    SessionService sessionService;


    @RequestMapping(value = "/invoices")
    public ModelAndView mainPageInvoices() {
        List<Subscription> t=sub.getSubscriptionByUserID();
        List<User> users =u.searchUsers();
        List<Tarif> tarifs =tarifService.getTarifs();
        List<Invoice> invoices = invoiceService.InvoiceByDate(convertUtilToSql(new Date()));
        String desktop=System.getProperty("user.home") + "/Desktop/";
        ModelAndView modelAndView=new ModelAndView("usersinvoices");
        modelAndView.addObject("subscriptions",t);
        modelAndView.addObject("users",users);
        modelAndView.addObject("tarifs",tarifs);
        modelAndView.addObject("invoices",invoices);
        modelAndView.addObject("desktop",desktop);

        return modelAndView; }




    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @RequestMapping(value = "/algo")
    private ModelAndView testPDF() throws DocumentException, IOException {
        ModelAndView modelAndView=new ModelAndView("loader");
        Date today=new Date();
        List<Subscription> t=sub.getSubscriptionByUserID();
        List<User> users =u.searchUsers();
        List<Tarif> tarifs =tarifService.getTarifs();
        User currentUser = new User();
        Tarif tarif=new Tarif();
        for(Subscription inv:t) {
            for(User user:users){
                if(inv.getId_user()==user.getId()){currentUser=u.getUser(user.getId());
                    tarif=tarifService.getTarif(inv.getId_pricing());
                };
            }
            List<Session> sessions=sessionService.getUserSessions(currentUser.getId(),today);
            double total = 0;
            String filename = convertUtilToSql(today) +"-"+currentUser.getLastName()+"-"+currentUser.getFirstName();
            String filepath=System.getProperty("user.home") + "/Desktop/"+filename+".pdf";
            File file = new File(filepath);
            if (file.exists() == false) {
                file.createNewFile();
            }
            System.out.println(file.exists());
            System.out.println(file.getPath());
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            //Titre
            String title="DIGICAR - FACTURE DU  "+formatDate(today);
            Chapter chapter = new Chapter(new Paragraph(), 1);
            chapter.setNumberDepth(0);
            String clin = "Numéro Client :"+currentUser.getId();
            String name =currentUser.getLastName()+ " "+currentUser.getFirstName();
            String adress =currentUser.getAddressLine1()+ " "+currentUser.getAddressLine2();
            String emailNNumber=currentUser.getPhoneNumber()+ " - "+currentUser.getEmail();
            String zipNcity=currentUser.getCity()+" "+currentUser.getZipCode();
            String separator="__________________________";
            //informations sur le Tarif
            String libelle_t="Tarif "+tarif.getLibelle()+" (depuis le "+formatDate(inv.getStart_date())+")";
            String prices=tarif.getPrix_heure()+" €/heure  "+tarif.getPrix_km()+ " €/km  "+tarif.getFrais_mensuels()+" €/mois  ";
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
            Invoice invoice=new Invoice(currentUser.getId(), today, total, filepath.replace(System.getProperty("user.home") + "/Desktop/",""));
            invoiceService.addInvoice(invoice);
            List<Session> sessionsOfTheMonth =sessionService.getUserSessions(currentUser.getId(),today);
            System.out.print(sessionsOfTheMonth.size());

            for(Session ses:sessionsOfTheMonth){
                String dateOfsession = "Début " + formatDate(ses.getDeparture_date()) +" " +ses.getDeparture_date().getHours()+"h"+ses.getDeparture_date().getMinutes()
                        +" / Fin "
                        + formatDate(ses.getArrival_date())+ " "+ses.getArrival_date().getHours()+"h"+ses.getArrival_date().getMinutes();
                String duration =dureeSessionToString((Timestamp)ses.getDeparture_date(),(Timestamp)ses.getArrival_date());
                Car c=carService.getCarById(ses.getId_car());
               String car=c.getMark()+" "+c.getName_model();
                 String kms="Km parcourus : "+ses.getKms();
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
    public String formatDate(Date d){
        SimpleDateFormat formater = new SimpleDateFormat("dd MMMMM yyyy");
        return formater.format(d);}

        public double dureeSession(Timestamp timestamp1, Timestamp timestamp2){
            long milliseconds = timestamp2.getTime() - timestamp1.getTime();
            int seconds = (int) milliseconds / 1000;

            // calculate hours minutes and seconds
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            seconds = (seconds % 3600) % 60;


            System.out.println("timestamp1: " + timestamp1);
            System.out.println("timestamp2: " + timestamp2);

            System.out.println("Difference: ");
            System.out.println(" Hours: " + hours);
            System.out.println(" Minutes: " + minutes);
            System.out.println(" Seconds: " + seconds);
        return hours+(minutes/60);
        }


    public String dureeSessionToString(Timestamp timestamp1, Timestamp timestamp2) {
        long milliseconds = timestamp2.getTime() - timestamp1.getTime();
        int seconds = (int) milliseconds / 1000;

        // calculate hours minutes and seconds
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;


        System.out.println("timestamp1: " + timestamp1);
        System.out.println("timestamp2: " + timestamp2);

        System.out.println("Difference: ");
        System.out.println(" Hours: " + hours);
        System.out.println(" Minutes: " + minutes);
        System.out.println(" Seconds: " + seconds);

        return hours+"h "+minutes+ " minutes";
    }
}

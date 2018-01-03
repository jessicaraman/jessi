package fr.digicar.webportal.controller;

import fr.digicar.model.User;
import fr.digicar.webportal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    private User user;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView registerUser() {
        log.debug("UserController#registerUser");
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView registerUserPersonalInfo(@ModelAttribute User user) {
        log.debug("UserController#registerUserPerosnalInfo");
        log.debug("user.email : " + user.getEmail());
        log.debug("user.password : " + user.getPassword());
        log.debug("user.passwordConfirm : " + user.getPasswordConfirm());
        ModelAndView modelAndView;
        if (!userService.checkEmailExistence(user.getEmail())) {
            modelAndView = new ModelAndView("registration");
            modelAndView.addObject("message", "Cette adresse email est déjà enregistrée.");
            user.setPassword(null);
            user.setPasswordConfirm(null);
        } else if (!user.getPassword().equals(user.getPasswordConfirm())) {
            modelAndView = new ModelAndView("registration");
            modelAndView.addObject("message", "Les mots de passe renseignés doivent être identiques.");
            user.setPassword(null);
            user.setPasswordConfirm(null);
        } else {
            this.user = user;
            modelAndView = new ModelAndView("registration-personal-info");
        }
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView confirmUserRegistration(@ModelAttribute User user) throws ParseException {
        log.debug("UserController#confirmUserRegistration");
        log.debug("user : " + user);
        user.setEmail(this.user.getEmail());
        user.setPassword(this.user.getPassword());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthdate(format.parse(user.getBirthdateString()));
        userService.createUser(user);
        return new ModelAndView("registration-confirm");
    }

}

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

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    private User user;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registerUser() {
        log.debug("UserController#registerUser");
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserPerosnalInfo(@ModelAttribute User user) {
        log.debug("UserController#registerUserPerosnalInfo");
        log.debug("user.email : " + user.getEmail());
        log.debug("user.password : " + user.getPassword());
        log.debug("user.passwordConfirm : " + user.getPasswordConfirm());
        ModelAndView modelAndView;
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
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

    @RequestMapping(value = "/registration/confirm", method = RequestMethod.POST)
    public ModelAndView confirmUserRegistration(@ModelAttribute User user) {
        log.debug("UserController#confirmUserRegistration");
        log.debug("user : " + user);
        user.setEmail(this.user.getEmail());
        user.setPassword(this.user.getPassword());
        userService.createUser(user);
        return new ModelAndView("registration-confirm");
    }

    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}

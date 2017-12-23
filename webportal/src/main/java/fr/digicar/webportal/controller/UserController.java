package fr.digicar.webportal.controller;

import fr.digicar.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class UserController {

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public ModelAndView createUser() {
        log.debug("UserController#createUser");
        ModelAndView modelAndView = new ModelAndView("create-user");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public ModelAndView creatingUser(@ModelAttribute User user) {
        log.debug("UserController#creatingUser");
        log.debug("user.password : " + user.getPassword());
        log.debug("user.passwordConfirm : " + user.getPasswordConfirm());
        ModelAndView modelAndView;
        if (user.getPassword().equals(user.getPasswordConfirm())) {
            modelAndView = new ModelAndView("create-user-personal-info");
            modelAndView.addObject("user", user);
        } else {
            modelAndView = new ModelAndView("create-user");
            modelAndView.addObject("message", "Les mots de passe renseignés doivent être identiques");
        }
        return modelAndView;
    }

}

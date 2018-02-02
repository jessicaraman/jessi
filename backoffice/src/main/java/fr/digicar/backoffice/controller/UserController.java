package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        log.debug("UserController#registerUser");

        ModelAndView modelAndView = new ModelAndView("search-users");
        modelAndView.addObject("users", userService.searchUsers());
        return modelAndView;
    }

}

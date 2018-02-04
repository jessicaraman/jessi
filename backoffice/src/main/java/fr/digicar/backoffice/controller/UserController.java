package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.UserService;
import fr.digicar.backoffice.utils.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;

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
        modelAndView.addObject("searchCriteria", new SearchCriteria());
        modelAndView.addObject("dateFormat", new SimpleDateFormat("dd/MM/yyyy"));
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String filterUsers(@ModelAttribute SearchCriteria searchCriteria, ModelMap model) {
        model.addAttribute("users", userService.searchUsers(searchCriteria));
        return "search-users";
    }

}

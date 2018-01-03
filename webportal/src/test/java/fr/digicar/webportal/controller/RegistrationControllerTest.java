package fr.digicar.webportal.controller;

import fr.digicar.model.User;
import fr.digicar.webportal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

public class RegistrationControllerTest {

    @Test
    public void registerUserReturnsCorrectModelAndView() {
        ModelAndView modelAndView = new RegistrationController().registerUser();
        assertEquals("registration", modelAndView.getViewName());
        assertEquals(new User(), modelAndView.getModel().get("user"));
    }

//    @Test
//    public void registerUserPersonalInfoReturnsCorrectModelAndView() {
//        User user = new User();
//        user.setEmail("test@email.com");
//        user.setPassword("password");
//        user.setPasswordConfirm("password");
//        assertEquals("registration-personal-info", new RegistrationController().registerUserPersonalInfo(user).getViewName());
//    }
//
//    @Test
//    public void registerUserPersonalInfoReturnsErrorModelAndView() {
//        User user = new User();
//        user.setEmail("test@email.com");
//        user.setPassword("password");
//        user.setPasswordConfirm("passwd");
//        ModelAndView modelAndView = new RegistrationController().registerUserPersonalInfo(user);
//        assertEquals("registration", modelAndView.getViewName());
//        assertEquals("Les mots de passe renseignés doivent être identiques.", modelAndView.getModel().get("message"));
//    }

}

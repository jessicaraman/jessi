package fr.digicar.webportal.controller;

import fr.digicar.model.User;
import fr.digicar.webportal.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegistrationControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private RegistrationController registrationController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void registerUserReturnsCorrectModelAndView() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration.jsp"))
                .andExpect(model().attributeHasNoErrors());
    }

    @Test
    public void registerUserReturnsUserPersonalInfo() throws Exception {
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        when(userService.checkEmailExistence(user.getEmail())).thenReturn(true);

        mockMvc.perform(post("/registration")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("passwordConfirm", user.getPasswordConfirm())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("registration-personal-info"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration-personal-info.jsp"));
    }

    @Test
    public void registerUserReturnsPasswordError() throws Exception {
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("password");
        user.setPasswordConfirm("passwd");
        when(userService.checkEmailExistence(user.getEmail())).thenReturn(true);

        mockMvc.perform(post("/registration")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("passwordConfirm", user.getPasswordConfirm())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("registration"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration.jsp"))
                .andExpect(model().attribute("message", "Les mots de passe renseignés doivent être identiques."));
    }

    @Test
    public void registerUserReturnsEmailError() throws Exception {
        User user = new User();
        user.setEmail("test@email.com");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        when(userService.checkEmailExistence(user.getEmail())).thenReturn(false);

        mockMvc.perform(post("/registration")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("passwordConfirm", user.getPasswordConfirm())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("registration"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration.jsp"))
                .andExpect(model().attribute("message", "Cette adresse email est déjà enregistrée."));
    }

    @Test
    public void registerUserPersonalInfoReturnsConfirmation() throws Exception {
        User thisuser = new User();
        thisuser.setEmail("test@email.com");
        thisuser.setPassword("password");
        this.registrationController.user = thisuser;
        User user = new User();
        user.setGender("M.");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setBirthdateString("1990-01-01");
        user.setPhoneNumber("0000000000");
        user.setAddressLine1("1st Test Street");
        user.setZipCode("00000");
        user.setCity("Test City");

        mockMvc.perform(post("/registration/confirm")
                .param("gender", user.getGender())
                .param("firstName", user.getFirstName())
                .param("lastName", user.getLastName())
                .param("birthdateString", user.getBirthdateString())
                .param("phoneNumber", user.getPhoneNumber())
                .param("addressLine1", user.getAddressLine1())
                .param("zipCode", user.getZipCode())
                .param("city", user.getCity())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("registration-confirm"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration-confirm.jsp"));
    }

    @Test
    public void registerUserPersonalInfoReturnsAgeError() throws Exception {
        User thisuser = new User();
        thisuser.setEmail("test@email.com");
        thisuser.setPassword("password");
        this.registrationController.user = thisuser;
        User user = new User();
        user.setGender("M.");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setBirthdateString(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setPhoneNumber("0000000000");
        user.setAddressLine1("1st Test Street");
        user.setZipCode("00000");
        user.setCity("Test City");

        mockMvc.perform(post("/registration/confirm")
                .param("gender", user.getGender())
                .param("firstName", user.getFirstName())
                .param("lastName", user.getLastName())
                .param("birthdateString", user.getBirthdateString())
                .param("phoneNumber", user.getPhoneNumber())
                .param("addressLine1", user.getAddressLine1())
                .param("zipCode", user.getZipCode())
                .param("city", user.getCity())
        )
                .andExpect(status().isOk())
                .andExpect(view().name("registration-personal-info"))
                .andExpect(forwardedUrl("/WEB-INF/pages/registration-personal-info.jsp"))
                .andExpect(model().attribute("message", "Vous devez avoir plus de 21 ans pour vous inscrire."));
    }

    @Test
    public void calculateAgeReturnsCorrectValues() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = simpleDateFormat.parse("1961-05-17");
        Date actual = simpleDateFormat.parse("2016-07-12");

        Assert.assertEquals(55, RegistrationController.calculateAge(birthdate, actual));
    }

}

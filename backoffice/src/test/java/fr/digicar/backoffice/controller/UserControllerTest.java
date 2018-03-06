package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.UserService;
import fr.digicar.model.User;
import fr.digicar.model.UserStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void showUsers() throws Exception {
        List<User> usersFromService = new ArrayList<>();
        User user1 = new User(0, "M.", "Test", "Test", "test1@email.com", "password", null, "1st Test Street", null, "00000", "Test City", "0000000001", new Date(631152000000L), null, new Date(), UserStatus.ACTIVE);
        User user2 = new User(1, "Mme", "Test", "Test", "test2@email.com", "password", null, "2nd Test Street", null, "00000", "Test City", "0000000002", new Date(662688000000L), null, new Date(), UserStatus.INACTIVE);
        User user3 = new User(2, "Mme", "Test", "Test", "test3@email.com", "password", null, "3rd Test Street", null, "00000", "Test City", "0000000003", new Date(694224000000L), null, new Date(), UserStatus.BANNED);
        usersFromService.add(user1);
        usersFromService.add(user2);
        usersFromService.add(user3);
        when(userService.searchUsers()).thenReturn(usersFromService);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("search-users"))
                .andExpect(forwardedUrl("/WEB-INF/pages/search-users.jsp"))
                .andExpect(model().attribute("users", usersFromService));
    }
}
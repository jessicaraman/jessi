package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.*;
import fr.digicar.model.CalculatedDelay;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MonitorSessionControllerTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private UserService userService;

    @Mock
    private CommercialGestureService commercialGestureService;

    @Mock
    private CalculatedDelayService calculatedDelayService;

    @Mock
    private CurrentSessionService currentSessionService;

    @InjectMocks
    private MonitorSessionController monitorSessionController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(monitorSessionController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void addMonitorCoursePageReturnsCorrectModelAndView() throws Exception {
        mockMvc.perform(get("/modifurgent"))
                .andExpect(status().isOk())
                .andExpect(view().name("emergency-modification/monitoring-course-form"))
                .andExpect(forwardedUrl("/WEB-INF/pages/emergency-modification/monitoring-course-form.jsp"))
                .andExpect(model().attribute("ligneRetard", new CalculatedDelay()));
    }

}
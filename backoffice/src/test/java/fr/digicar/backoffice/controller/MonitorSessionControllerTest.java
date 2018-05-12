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
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
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

    @Test
    public void edditingClotureLigneRetard() throws Exception {
        CalculatedDelay calculatedDelay = new CalculatedDelay();
        calculatedDelay.setId(1);

        when(calculatedDelayService.getCalculatedDelayById(anyInt())).thenReturn(calculatedDelay);

        mockMvc.perform(get("/modifurgent/cloturer/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("emergency-modification/monitoring-course-form"))
                .andExpect(forwardedUrl("/WEB-INF/pages/emergency-modification/monitoring-course-form.jsp"))
                .andExpect(model().attribute("ligneRetard", new CalculatedDelay()));
    }

    @Test
    public void affichageMultiTableReturnsCorrectObject() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        CalculatedDelay calculatedDelay1 = new CalculatedDelay();
        CalculatedDelay calculatedDelay2 = new CalculatedDelay();
        CalculatedDelay calculatedDelay3 = new CalculatedDelay();
        calculatedDelay1.setExpectedReturnTime(new Time(1514764800000L));
        calculatedDelay1.setCalculatedReturnTime(new Time(1514772000000L));
        calculatedDelay1.setTagAppel(false);
        calculatedDelay2.setExpectedReturnTime(new Time(1514772000000L));
        calculatedDelay2.setCalculatedReturnTime(new Time(1514764800000L));
        calculatedDelay2.setTagAppel(false);
        calculatedDelay3.setExpectedReturnTime(new Time(1514764800000L));
        calculatedDelay3.setCalculatedReturnTime(new Time(1514772000000L));
        calculatedDelay3.setTagAppel(true);

        List<CalculatedDelay> submittedList = new ArrayList<>();
        submittedList.add(calculatedDelay1);
        submittedList.add(calculatedDelay2);
        submittedList.add(calculatedDelay3);

        List<CalculatedDelay> calculatedDelays1 = new ArrayList<>();
        List<CalculatedDelay> calculatedDelays2 = new ArrayList<>();
        List<CalculatedDelay> calculatedDelays3 = new ArrayList<>();
        calculatedDelays1.add(calculatedDelay1);
        calculatedDelays2.add(calculatedDelay2);
        calculatedDelays3.add(calculatedDelay3);

        Method method = MonitorSessionController.class.getDeclaredMethod("affichageMultiTable", List.class, ModelAndView.class);
        method.setAccessible(true);

        ModelAndView modelAndView = (ModelAndView) method.invoke(monitorSessionController, submittedList, new ModelAndView());

        assertEquals(modelAndView.getModel().get("retardCalcule"), calculatedDelays1);
        assertEquals(modelAndView.getModel().get("retardCalculeAppeler"), calculatedDelays3);
        assertEquals(modelAndView.getModel().get("retardCalculeNonEnRetard"), calculatedDelays2);
    }

}
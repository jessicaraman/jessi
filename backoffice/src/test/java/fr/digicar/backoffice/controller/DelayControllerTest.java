package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.DelayService;
import fr.digicar.backoffice.utils.DelayDistribution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DelayControllerTest {

    @Mock
    private DelayService delayService;

    @InjectMocks
    private DelayController delayController;

    private MockMvc mockMvc;

    private Date dateStart = new Date(1514764800000L);
    private Date dateEnd = new Date(1546300799000L);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(delayController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void delayDashboardIsOk() throws Exception {
        when(delayService.getDelayNumber(dateStart, dateEnd)).thenReturn(1000);
        when(delayService.getDelayDistribution(dateStart, dateEnd)).thenReturn(new DelayDistribution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"1-3", "4-6", "7-8", "9-10"}));

        mockMvc.perform(get("/delays"))
                .andExpect(status().isOk())
                .andExpect(view().name("delay-analysis"))
                .andExpect(forwardedUrl("/WEB-INF/pages/delay-analysis.jsp"))
                .andExpect(model().attribute("delayNumber", 1000))
                .andExpect(model().attribute("delayDistribution", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .andExpect(model().attribute("delayDistributionLabels", new String[]{"1-3", "4-6", "7-8", "9-10"}));
    }

    @Test
    public void getPreviousYearDateReturnLastYearsDate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = DelayController.class.getDeclaredMethod("getPreviousYearDate", Date.class);
        method.setAccessible(true);

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        assertEquals(new Date(1483228800000L), method.invoke(delayController, dateStart));
    }

    @Test
    public void getResultDateStringReturnsCorrectString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = DelayController.class.getDeclaredMethod("getResultDateString", Date.class, Date.class);
        method.setAccessible(true);

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        assertEquals("Janvier 2018 - Décembre 2018", method.invoke(delayController, dateStart, dateEnd));
    }

}
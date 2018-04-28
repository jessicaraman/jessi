package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.DelayService;
import fr.digicar.backoffice.utils.DelayDistribution;
import fr.digicar.backoffice.utils.SearchPeriod;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.exparity.hamcrest.date.DateMatchers.sameDay;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
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
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(delayController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void delayDashboardIsOk() throws Exception {
        when(delayService.getDelayNumber(any(Date.class), any(Date.class))).thenReturn(1000);
        when(delayService.getDelayDistribution(any(Date.class), any(Date.class))).thenReturn(new DelayDistribution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"1-3", "4-6", "7-8", "9-10"}));

        mockMvc.perform(get("/delays"))
                .andExpect(status().isOk())
                .andExpect(view().name("delay-analysis"))
                .andExpect(forwardedUrl("/WEB-INF/pages/delay-analysis.jsp"))
                .andExpect(model().attribute("delayNumber", 1000))
                .andExpect(model().attribute("delayDistribution", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .andExpect(model().attribute("delayDistributionLabels", new String[]{"1-3", "4-6", "7-8", "9-10"}))
                .andExpect(model().attribute("searchPeriod", new SearchPeriod()));
    }

    @Test
    public void filterByDateReturnsStringView() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        SearchPeriod searchPeriod = new SearchPeriod();
        searchPeriod.setStartDateString("2017-01-01");
        searchPeriod.setStartDate(new Date(1483228800000L));
        searchPeriod.setEndDateString("2018-01-01");
        searchPeriod.setEndDate(new Date(1514764800000L));

        when(delayService.getDelayNumber(any(Date.class), any(Date.class))).thenReturn(1000);
        when(delayService.getDelayDistribution(any(Date.class), any(Date.class))).thenReturn(new DelayDistribution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"1-3", "4-6", "7-8", "9-10"}));

        mockMvc.perform(post("/delays")
                .param("startDateString", "2017-01-01")
                .param("endDateString", "2018-01-01")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("delay-analysis"))
                .andExpect(forwardedUrl("/WEB-INF/pages/delay-analysis.jsp"))
                .andExpect(model().attribute("delayNumber", 1000))
                .andExpect(model().attribute("delayDistribution", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .andExpect(model().attribute("delayDistributionLabels", new String[]{"1-3", "4-6", "7-8", "9-10"}))
                .andExpect(model().attribute("searchPeriod", searchPeriod));
    }

    @Test
    public void filterByDateReturnsCorrectModelAndViewOnParseException() throws Exception {
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.YEAR, -1);
        Date aYearAgo = cal.getTime();
        String startDateString = "abcd";
        String endDateString = "defg";

        when(delayService.getDelayNumber(any(Date.class), any(Date.class))).thenReturn(1000);
        when(delayService.getDelayDistribution(any(Date.class), any(Date.class))).thenReturn(new DelayDistribution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"1-3", "4-6", "7-8", "9-10"}));

        mockMvc.perform(post("/delays")
                .param("startDateString", startDateString)
                .param("endDateString", endDateString)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("delay-analysis"))
                .andExpect(forwardedUrl("/WEB-INF/pages/delay-analysis.jsp"))
                .andExpect(model().attribute("delayNumber", 1000))
                .andExpect(model().attribute("delayDistribution", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .andExpect(model().attribute("delayDistributionLabels", new String[]{"1-3", "4-6", "7-8", "9-10"}))
                .andExpect(model().attribute("searchPeriod", hasProperty("startDateString", hasToString(startDateString))))
                .andExpect(model().attribute("searchPeriod", hasProperty("endDateString", hasToString(endDateString))))
                .andExpect(model().attribute("searchPeriod", hasProperty("startDate", sameDay(aYearAgo))))
                .andExpect(model().attribute("searchPeriod", hasProperty("endDate", sameDay(today))));
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

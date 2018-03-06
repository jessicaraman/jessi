package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.controller.ParkingSpotController;
import fr.digicar.backoffice.service.ParkingSpotService;
import fr.digicar.model.ParkingSpot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ParkingSpotControllerTest {

    @Mock
    ParkingSpotService parkingSpotService;

    @InjectMocks
    ParkingSpotController parkingSpotController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(parkingSpotController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void addCreateParkingSpotPageReturnsCorrectModelAndView() throws Exception {
        mockMvc.perform(get("/parking/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-parking-spot-form"))
                .andExpect(forwardedUrl("/WEB-INF/pages/add-parking-spot-form.jsp"))
                .andExpect(model().attribute("parking", new ParkingSpot()));
    }

    @Test
    public void addingParkingSpotReturnsCorrectModelAndView() throws Exception {
        ParkingSpot parkingSpot = new ParkingSpot(1, 1, "12", true, "location1", 1, 1, 1, 1);
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(parkingSpot);
        when(parkingSpotService.getParkingSpots()).thenReturn(parkingSpots);

        mockMvc.perform(post("/parking/add")
                .param("nbSpot", "1")
                .param("nbParking", parkingSpot.getNbParking())
                .param("plug", "true")
                .param("location", parkingSpot.getLocation())
                .param("longitude", "1")
                .param("latitude", "1")
                .param("longueur", "1")
                .param("largeur", "1")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("menu-parking-spot-form"))
                .andExpect(forwardedUrl("/WEB-INF/pages/menu-parking-spot-form.jsp"))
                //.andExpect(model().attribute("message", parkingSpot.getNbSpot() + " ont été ajoutées."))
                .andExpect(model().attribute("parkingSpot", parkingSpots));


    }

}
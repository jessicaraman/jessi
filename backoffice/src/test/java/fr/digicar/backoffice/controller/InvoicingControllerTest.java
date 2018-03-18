package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.ResultMatcher;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InvoicingControllerTest {

    @Mock
    SubscriptionService sub;
    @Mock
    UserService u;
    @Mock
    TarifService tarifService;
    @Mock
    InvoiceService invoiceService;
    @Mock
    CarService carService;
    @Mock
    SessionService sessionService;

    @InjectMocks
    private InvoicingController invoicingController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(sub).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(u).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(tarifService).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(invoiceService).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(carService).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(sessionService).build();

    }

    @Test
    public void mainPageInvoices() throws Exception {
    }

    @Test
    public void formatDate() {
    }

    @Test
    public void dureeSession() {
    }

    @Test
    public void dureeSessionToString() {

    }
}
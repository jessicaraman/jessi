package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class InvoicingControllerTest {

    @Mock
    private SubscriptionService sub;

    @Mock
    private UserService u;

    @Mock
    private TarifService tarifService;

    @Mock
    private InvoiceService invoiceService;

    @Mock
    private CarService carService;

    @Mock
    private SessionService sessionService;

    @InjectMocks
    private InvoicingController invoicingController;

    @Before
    public void setup() {
        // Setup Spring test in standalone mode
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(sub).build();
        mockMvc = MockMvcBuilders.standaloneSetup(u).build();
        mockMvc = MockMvcBuilders.standaloneSetup(tarifService).build();
        mockMvc = MockMvcBuilders.standaloneSetup(invoiceService).build();
        mockMvc = MockMvcBuilders.standaloneSetup(carService).build();
        mockMvc = MockMvcBuilders.standaloneSetup(sessionService).build();
    }

    @Test
    public void mainPageInvoices() {
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
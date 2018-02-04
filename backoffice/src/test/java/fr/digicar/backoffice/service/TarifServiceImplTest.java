package fr.digicar.backoffice.service;

import fr.digicar.dao.TarifDAO;
import fr.digicar.init.WebAppConfig;
import fr.digicar.model.Tarif;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
@WebAppConfiguration


public class TarifServiceImplTest {
    @Mock
    private TarifDAO tarifDAO;

    @InjectMocks
    private TarifServiceImpl tarifServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTarifShouldReturnTarifRegistered() throws Exception {
        //
        //GIVEN
        //
        Tarif expectedResult = new Tarif();
        expectedResult.setId(1);
        expectedResult.setLibelle("Test1");
        expectedResult.setPrix_heure(5);
        expectedResult.setPrix_km(4);
        expectedResult.setFrais_mensuels(2);

        when(tarifServiceImpl.getTarif(expectedResult.getId())).thenReturn(expectedResult);
        tarifDAO.addTarif(expectedResult);

        //
        //WHEN
        //
        Tarif enterTarif = tarifServiceImpl.getTarif(1);

        //
        //THEN
        //

        Assert.assertEquals(expectedResult, enterTarif);
        Assert.assertEquals(expectedResult.hashCode(), enterTarif.hashCode());
        Assert.assertEquals(expectedResult.toString(), enterTarif.toString());

    }

}
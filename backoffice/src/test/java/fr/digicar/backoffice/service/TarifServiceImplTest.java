package fr.digicar.backoffice.service;

import fr.digicar.dao.TarifDAO;
import fr.digicar.model.Tarif;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TarifServiceImplTest {

    @Mock
    private TarifDAO tarifDAO;

    @InjectMocks
    private TarifServiceImpl tarifServiceImpl;

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
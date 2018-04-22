package fr.digicar.backoffice.service;

import fr.digicar.dao.PricingDAO;
import fr.digicar.model.Pricing;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceImplTest {

    @Mock
    private PricingDAO pricingDAO;

    @InjectMocks
    private TarifServiceImpl tarifServiceImpl;

    @Test
    public void getTarifShouldReturnTarifRegistered() {
        //
        //GIVEN
        //
        Pricing expectedResult = new Pricing();
        expectedResult.setId(1);
        expectedResult.setLabel("Test1");
        expectedResult.setHourlyPrice(5);
        expectedResult.setKmPrice(4);
        expectedResult.setMonthlyFees(2);

        when(tarifServiceImpl.getTarif(expectedResult.getId())).thenReturn(expectedResult);
        pricingDAO.addTarif(expectedResult);

        //
        //WHEN
        //
        Pricing enterPricing = tarifServiceImpl.getTarif(1);

        //
        //THEN
        //
        Assert.assertEquals(expectedResult, enterPricing);
        Assert.assertEquals(expectedResult.hashCode(), enterPricing.hashCode());
        Assert.assertEquals(expectedResult.toString(), enterPricing.toString());
    }

}
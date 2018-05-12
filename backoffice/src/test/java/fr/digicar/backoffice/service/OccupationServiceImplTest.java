/*
package fr.digicar.backoffice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OccupationServiceImplTest {

    @Mock
    private OccupationDAO occupationDAO;

    @InjectMocks
    private OccupationServiceImpl occupationService;

    @Test
    public void listAllOccupationsShouldReturnAllOccupations() {
        List<Occupation> occupations = new ArrayList<>();
        occupations.add(new Occupation(1, 1));
        occupations.add(new Occupation(4, 5));
        occupations.add(new Occupation(3, 9));
        occupations.add(new Occupation(2, 7));
        Mockito.when(occupationDAO.getAllOccupations()).thenReturn(occupations);

        List<Occupation> occupationListTest = occupationService.getAllOccupations();

        Assert.assertEquals(occupations, occupationListTest);
    }

}
*/

package fr.digicar.webportal.controller;

import fr.digicar.dao.OccupationDAO;
import fr.digicar.model.Occupation;
import fr.digicar.webportal.service.OccupationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class OccupationServiceImplTest {

    @Mock
    private OccupationDAO occupationDAO;

    @InjectMocks
    private OccupationServiceImpl occupationService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listAllOccupationsShouldReturnAllOccupations(){

        List<Occupation> occupations = new ArrayList<>();
        occupations.add(new Occupation(1,1,1));
        occupations.add(new Occupation(2,4,5));
        occupations.add(new Occupation(3,3,9));
        occupations.add(new Occupation(4,2,7));
        Mockito.when(occupationDAO.getAllOccupations()).thenReturn(occupations);

        List<Occupation> occupationListTest = occupationService.getAllOccupations();

        Assert.assertEquals(occupations, occupationListTest);
    }

}

package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.SearchCriteria;
import fr.digicar.model.UserStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceImplTest {

    @Test
    public void generateSearchStringReturnsQueryWithAllCriteria() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("Test");
        searchCriteria.setDepartments(new String[]{"75", "92", "94"});
        searchCriteria.setStatuses(new UserStatus[]{UserStatus.ACTIVE, UserStatus.INACTIVE});

        String expectedQueryString = "from User where " +
                "(firstName like '%Test%' or lastName like '%Test%') " +
                "and (zipCode like '75%' or zipCode like '92%' or zipCode like '94%') " +
                "and (status = 'ACTIVE' or status = 'INACTIVE')";

        assertEquals(expectedQueryString, new UserServiceImpl().generateSearchString(searchCriteria));
    }

    @Test
    public void generateSearchStringReturnsQueryWithSomeCriteria() {
        SearchCriteria searchCriteria1 = new SearchCriteria();
        searchCriteria1.setName("Test");
        String expectedQueryString1 = "from User where " +
                "(firstName like '%Test%' or lastName like '%Test%')";

        SearchCriteria searchCriteria2 = new SearchCriteria();
        searchCriteria2.setName("Test");
        searchCriteria2.setStatuses(new UserStatus[]{UserStatus.ACTIVE, UserStatus.BANNED});
        String expectedQueryString2 = expectedQueryString1 +
                " and (status = 'ACTIVE' or status = 'BANNED')";

        assertEquals(expectedQueryString1, new UserServiceImpl().generateSearchString(searchCriteria1));
        assertEquals(expectedQueryString2, new UserServiceImpl().generateSearchString(searchCriteria2));
    }

}

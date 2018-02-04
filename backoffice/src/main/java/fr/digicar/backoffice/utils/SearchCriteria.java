package fr.digicar.backoffice.utils;

import fr.digicar.model.UserStatus;
import lombok.Data;

@Data
public class SearchCriteria {

    String name;

    String[] departments;

    UserStatus[] statuses;

}

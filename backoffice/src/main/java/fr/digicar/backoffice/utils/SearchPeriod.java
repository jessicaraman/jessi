package fr.digicar.backoffice.utils;

import lombok.Data;

import java.util.Date;

@Data
public class SearchPeriod {

    private Date startDate;

    private String startDateString;

    private Date endDate;

    private String endDateString;

}

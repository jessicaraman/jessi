package fr.digicar.backoffice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DelayDistribution {

    private int[] values;

    private String[] labels;

}

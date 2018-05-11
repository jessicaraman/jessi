package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.DelayDistribution;
import fr.digicar.dao.DelayDAO;
import fr.digicar.model.Delay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DelayServiceImpl implements DelayService {

    @Autowired
    private DelayDAO delayDAO;

    @Override
    public DelayDistribution getDelayDistribution(Date dateStart, Date dateEnd) {
        int[] values = getDelayValues(delayDAO.filterByDate(dateStart, dateEnd));

        int[] distribution = new int[4];

        int firstQuartile = getQuartile(values, 25);
        int secondQuartile = getQuartile(values, 50);
        int thirdQuartile = getQuartile(values, 75);

        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int value : values) {
                switch (i) {
                    case 0:
                        if (value >= values[0] && value < firstQuartile) count++;
                        break;
                    case 1:
                        if (value >= firstQuartile && value < secondQuartile) count++;
                        break;
                    case 2:
                        if (value >= secondQuartile && value < thirdQuartile) count++;
                        break;
                    case 3:
                        if (value >= thirdQuartile && value <= values[values.length - 1]) count++;
                        break;
                }
            }
            distribution[i] = count;
        }
        return new DelayDistribution(distribution, getQuartileLabels(new int[]{values[0], firstQuartile, secondQuartile, thirdQuartile, values[values.length - 1]}));
    }

    @Override
    public int getDelayNumber(Date dateStart, Date dateEnd) {
        Date today = new Date();
        return delayDAO.countByDate(dateStart, dateEnd);
    }

    private String[] getQuartileLabels(int[] quartiles) {
        String[] labels = new String[4];
        labels[0] = String.valueOf(quartiles[0]) + "-" + String.valueOf(quartiles[1]) + " min.";
        labels[1] = String.valueOf(quartiles[1] + 1) + "-" + String.valueOf(quartiles[2]) + " min.";
        labels[2] = String.valueOf(quartiles[2] + 1) + "-" + String.valueOf(quartiles[3]) + " min.";
        labels[3] = String.valueOf(quartiles[3] + 1) + "-" + String.valueOf(quartiles[4]) + " min.";
        return labels;
    }

    private int getQuartile(int[] values, int lowerPercent) {
        int n = Math.round(values.length * lowerPercent / 100);
        return values[n];
    }

    private int[] getDelayValues(List<Delay> delays) {
        int[] values = new int[delays.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = delays.get(i).getDuration();
        }
        Arrays.sort(values);
        return values;
    }

    private double getStandardDeviation(int[] values) {
        double sum = 0.0;
        double standardDeviation = 0.0;
        for (double num : values) {
            sum += num;
        }
        double mean = sum / values.length;
        for (double num : values) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation / values.length - 1);
    }

}

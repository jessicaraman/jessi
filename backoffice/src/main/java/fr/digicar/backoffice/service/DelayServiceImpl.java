package fr.digicar.backoffice.service;

import fr.digicar.dao.DelayDAO;
import fr.digicar.model.Delay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DelayServiceImpl implements DelayService {

    @Autowired
    private DelayDAO delayDAO;

    @Override
    public int[] getDelayDistribution() {
        int[] distribution = new int[4];
        int[] values = getDelayValues(delayDAO.findAll());
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int value : values) {
                switch (i) {
                    case 0:
                        if (value >= values[0] && value < getQuartile(values, 25)) count++;
                        break;
                    case 1:
                        if (value >= getQuartile(values, 25) && value < getQuartile(values, 50)) count++;
                        break;
                    case 2:
                        if (value >= getQuartile(values, 50) && value < getQuartile(values, 75)) count++;
                        break;
                    case 3:
                        if (value >= getQuartile(values, 75) && value <= values[values.length-1]) count++;
                        break;
                }
            }
            distribution[i] = count;
        }
        return distribution;
    }

    @Override
    public int getDelayNumber() {
        return delayDAO.count();
    }

    private int getQuartile(int[] values, int lowerPercent) {
        int[] v = new int[values.length];
        Arrays.sort(v);
        int n = Math.round(v.length * lowerPercent / 100);
        return v[n];
    }

    private int[] getDelayValues(List<Delay> delays) {
        int[] values = new int[delays.size()];
        int i = 0;
        for (Delay delay : delays) {
            values[i] = delay.getDuration();
            i++;
        }
        return values;
    }

}

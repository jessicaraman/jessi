package fr.digicar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Time;
import java.util.Date;

import static org.junit.Assert.*;


//@RunWith(JUnitParamsRunner.class)
public class CalculatedDelayDAOImplTest {

    private CalculatedDelayDAOImpl calculatedDelayDAOImpl;

   /* int min;
    Date date;
    Time expected;
    private CalculatedDelayDAOImpl calculatedDelayDAOImpl;

    public CalculatedDelayDAOImplTest(int min,Date date, Time expected) {
        this.min=min;
        this.date= date;
        this.expected=expected;
    }


    @Parameterized.Parameters
    private Object[] parametersForAddSecondTest(){

            return new Object[][]{
                    {20,new Date(10,03,04,15,45,23),new Time(new Date(10,03,04,16,05,23).getTime())},

            };
        }

    @Test
    public void addSecondTest() {

        assertEquals(expected, calculatedDelayDAOImpl.addSecond(min,date));   }
    }*/
     @Test
    public void calculateDuration() {
    }

    @Test
    public void addSecondTest() {

       // assertEquals(new Time(new Date(10,03,04,16,05,23).getTime()), calculatedDelayDAOImpl.addSecond(20,new Date(10,03,04,15,45,23)));
    }
}


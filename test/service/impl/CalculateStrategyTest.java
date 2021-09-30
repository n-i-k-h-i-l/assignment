package service.impl;

import beans.IncomeData;
import beans.ReportData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.strategy.CalculateAverage;

import java.util.ArrayList;
import java.util.List;

public class CalculateStrategyTest {

    CalculatorStrategy avgStrategy;

    @Before
    public void setUp() throws Exception {
        // creating instance every time a test case runs
        avgStrategy = new CalculatorStrategy(new CalculateAverage());
    }

    public List<IncomeData> getDummyIncomeData() {
        List<IncomeData> list = new ArrayList<>();
        list.add(new IncomeData("Gurgaon", "India", "M", "INR", "15000"));
        list.add(new IncomeData("Gurgaon", "India", "M", "INR", "15000"));
        list.add(new IncomeData("Gurgaon", "India", "M", "INR", "15000"));
        return list;
    }

    @Test
    public void performAvergaeOperation() {

        ReportData data = avgStrategy.executeStrategy(getDummyIncomeData());
        Assert.assertEquals("15000.0", data.getAverageIncome());
        Assert.assertEquals("India", data.getCountry());
        Assert.assertEquals("M", data.getGender());
    }
}
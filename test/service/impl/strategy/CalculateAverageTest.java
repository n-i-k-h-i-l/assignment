package service.impl.strategy;

import beans.IncomeData;
import beans.ReportData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ICalculator;
import service.impl.CalculatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class CalculateAverageTest {

    ICalculator calc;

    @Before
    public void setUp() throws Exception {
        // creating instance every time a test case runs
        calc = new CalculateAverage();
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

        ReportData data = calc.performOperation(getDummyIncomeData());
        Assert.assertEquals("15000.0", data.getAverageIncome());
        Assert.assertEquals("India", data.getCountry());
        Assert.assertEquals("M", data.getGender());
    }
}
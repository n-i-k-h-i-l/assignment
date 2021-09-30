package service.impl;

import beans.IncomeData;
import beans.ReportData;
import exception.CustomException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IReportService;

import java.util.ArrayList;
import java.util.List;

public class ReportServiceTest {

    IReportService service;

    @Before
    public void setUp() throws Exception {
        // creating instance every time a test case runs
		service = ReportService.getInstance();
    }

    public List<IncomeData> getDummyIncomeData() {
        List<IncomeData> list = new ArrayList<>();
        list.add(new IncomeData("Gurgaon", "India", "M", "INR", "10000"));
        list.add(new IncomeData("Gurgaon", "India", "M", "INR", "15000"));
        list.add(new IncomeData("Gurgaon", "", "M", "INR", "15000"));
        list.add(new IncomeData("New Delhi", "", "F", "USD", "25000"));
        return list;
    }

    @Test
    public void getAverageIncomeDataTest() throws CustomException {

        List<IncomeData> data = getDummyIncomeData();
        List<ReportData> output = service.getAverageIncomeData(data);
        Assert.assertEquals(output.size(), 3);
        Assert.assertEquals(output.get(2).getAverageIncome(), "17.5");
        Assert.assertEquals(output.get(1).getAverageIncome(), "21.0");
        Assert.assertEquals(output.get(0).getAverageIncome(), "25000.0");
    }

}

package service.impl.reader;

import beans.IncomeData;
import beans.ReportData;
import constants.IAppConstants;
import exception.CustomException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ICalculator;
import service.ICustomFileReader;
import service.impl.strategy.CalculateAverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONReaderTest {

    ICustomFileReader jsonReader;


    @Before
    public void setUp() throws Exception {
        // creating instance every time a test case runs
        jsonReader = new JSONReader();
    }

    @Test
    public void readJSON() throws CustomException {

        Map<String,String> data = jsonReader.readFileAsKeyValue(IAppConstants.RATE_CONVERTOR_JSON_PATH);
        Assert.assertTrue(data.containsKey(IAppConstants.GBP_LBL));
        Assert.assertTrue(data.containsKey(IAppConstants.USD_LBL));
        Assert.assertTrue(data.containsKey(IAppConstants.HKD_LBL));
        Assert.assertTrue(data.containsKey(IAppConstants.INR_LBL));
        Assert.assertTrue(data.containsKey(IAppConstants.SGP_LBL));
    }
}
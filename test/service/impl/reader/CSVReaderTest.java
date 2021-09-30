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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CSVReaderTest {

    ICustomFileReader csvReader;

    @Before
    public void setUp() throws Exception {
        // creating instance every time a test case runs
        csvReader = new CSVReader();
    }

    public List<String> getSupportedCurrency(){
        return Arrays.asList(IAppConstants.GBP_LBL, IAppConstants.INR_LBL, IAppConstants.HKD_LBL, IAppConstants.SGP_LBL, IAppConstants.USD_LBL);
    }

    @Test
    public void readCSV() throws CustomException {

        List<IncomeData> data = csvReader.fetchIncomeData(new File(IAppConstants.INPUT_CSV_PATH));
        Assert.assertNotNull(data);
        for(IncomeData eachData : data){
            Assert.assertTrue(getSupportedCurrency().contains(eachData.getCurrency()));
        }

    }
}
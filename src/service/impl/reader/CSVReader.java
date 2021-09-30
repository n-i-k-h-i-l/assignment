package service.impl.reader;

import beans.IncomeData;
import exception.CustomException;
import service.ICustomFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVReader implements ICustomFileReader {
    @Override
    public List<IncomeData> fetchIncomeData(File file) throws CustomException {
        List<IncomeData> incomeDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            // Remove Header
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                incomeDataList.add(getIncomeDataObjectFromString(line));
            }
        } catch (IOException e) {
            throw new CustomException("Exception while Reading file of Income Data !!!");
        }
        return incomeDataList;
    }

    @Override
    public Map<String, String> readFileAsKeyValue(String path) {
        return null;
    }

    private IncomeData getIncomeDataObjectFromString(String commaSeperatedString) {
        String[] strArray = commaSeperatedString.split(",");
        IncomeData data = new IncomeData();
        data.setCity(strArray[0]);
        data.setCountry(strArray[1]);
        data.setGender(strArray[2]);
        data.setCurrency(strArray[3]);
        data.setAverageIncome(strArray[4]);
        return data;
    }
}

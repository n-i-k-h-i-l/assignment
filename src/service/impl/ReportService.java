package service.impl;

import beans.IncomeData;
import beans.ReportData;
import constants.IAppConstants;
import exception.CustomException;
import service.IReportService;
import service.impl.strategy.CalculateAverage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is a Service Class which does all the work to fetch and calculate data as per needs.
 * This class is being made Singleton to demonstrate Singleton Design pattern.
 */
public final class ReportService implements IReportService {

    private static IReportService service;

    private ReportService() {
    }

    public static IReportService getInstance() {
        if (service == null) {
            service = new ReportService();
        }
        return service;
    }

    @Override
    public List<IncomeData> fetchData(String path) throws CustomException {
        File input = new File(path);
        //check if file exists or not
        if (input.exists()) {
            return new ReaderFactory(getFileType(path)).getFileReader().fetchIncomeData(input);
        } else {
            throw new CustomException("file does not exist !!!");
        }
    }

    @Override
    public List<ReportData> getAverageIncomeData(List<IncomeData> incomeDataList) throws CustomException {
        List<ReportData> list = new ArrayList<>();

        // retrieving cloned copy for manipulating data
        List<IncomeData> clonedCopy = getClonedCopy(incomeDataList);
        // updating country for record if null
        cleanData(clonedCopy);

        // fetching data grouped by Country
        Map<String, List<IncomeData>> groupedByCountry = clonedCopy.stream()
                .collect(Collectors.groupingBy(IncomeData::getCountry));

        CalculatorStrategy ctx = new CalculatorStrategy(new CalculateAverage());

        groupedByCountry.forEach((k, v) -> {
            // fetching data grouped by Gender
            Map<String, List<IncomeData>> groupedByGender = v.stream()
                    .collect(Collectors.groupingBy(IncomeData::getGender));

            groupedByGender.forEach((k1, v1) -> {
                list.add(ctx.executeStrategy(v1));
            });
        });

        return list;
    }

    @Override
    public void writeDataToFile(String outputCsvPath, List<ReportData> data) throws CustomException {
        try (FileWriter outputWriter = new FileWriter(outputCsvPath, false)) {
            //Writing headers
            outputWriter.write(IAppConstants.OUTPUT_CSV_HEADERS + System.lineSeparator());

            //writing data
            for (ReportData eachData : data) {
                outputWriter.write(eachData.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new CustomException("Not able to write to the file !!!");
        }
    }


    // retrieving cloned copy
    private List<IncomeData> getClonedCopy(List<IncomeData> incomeDataList) {
        List<IncomeData> list = new ArrayList<>();
        for (IncomeData data : incomeDataList) {
            list.add(data.deepCopy());
        }
        return list;
    }

    /*
     * this method should be private only for jUnit purpose this method is made public
     */
    // updating country for record if null
    private void cleanData(List<IncomeData> incomeDataList) throws CustomException {
        for (IncomeData data : incomeDataList) {
            if (data.getCountry() == null || data.getCountry().equals("")) {
                data.setCountry(data.getCity());
            }
            data.setAverageIncome(convertTOUSD(data.getCurrency(), data.getAverageIncome()));
        }
    }

    private String convertTOUSD(String currency, String income) throws CustomException {
        Map<String, String> jsonMap = new ReaderFactory(getFileType(IAppConstants.RATE_CONVERTOR_JSON_PATH)).getFileReader().readFileAsKeyValue(IAppConstants.RATE_CONVERTOR_JSON_PATH);
        return String.valueOf(Double.valueOf(income) * Double.valueOf(jsonMap.get(currency)));
    }

    private String getFileType(String str){
        return str.substring(str.lastIndexOf(".") + 1,str.length());
    }

}

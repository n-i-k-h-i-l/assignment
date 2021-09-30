package service;

import beans.IncomeData;
import beans.ReportData;
import exception.CustomException;

import java.util.List;

public interface IReportService {

    public List<IncomeData> fetchData(String path) throws CustomException;

    public List<ReportData> getAverageIncomeData(List<IncomeData> incomeDataList) throws CustomException;

    public void writeDataToFile(String outputCsvPath, List<ReportData> averageIncomeData) throws Exception;

}

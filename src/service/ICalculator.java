package service;

import beans.IncomeData;
import beans.ReportData;

import java.util.List;

public interface ICalculator {

    ReportData performOperation(List<IncomeData> incomeDataList);

}

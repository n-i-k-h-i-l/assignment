package service.impl.strategy;

import beans.IncomeData;
import beans.ReportData;
import service.ICalculator;

import java.util.List;

public class CalculateAverage implements ICalculator {
    @Override
    public ReportData performOperation(List<IncomeData> incomeDataList) {
        ReportData data = new ReportData();
        data.setCountry(incomeDataList.get(0).getCountry());
        data.setGender(incomeDataList.get(0).getGender());

        // calculating Average
        double sum = 0;
        for (IncomeData eachData : incomeDataList) {
            sum += Double.valueOf(eachData.getAverageIncome());
        }
        data.setAverageIncome(String.valueOf(sum / incomeDataList.size()));
        return data;
    }
}

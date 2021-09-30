package service.impl;

import beans.IncomeData;
import beans.ReportData;
import service.ICalculator;

import java.util.List;

/**
 *  Calculator Strategy is created to demonstrate Strategy Design Pattern
 *  This class will execute calculation based on the implementation of Calculator passed in Constructor
 */
public class CalculatorStrategy {
    private ICalculator calc;

    public CalculatorStrategy(ICalculator calc){
        this.calc = calc;
    }

    public ReportData executeStrategy(List<IncomeData> incomeDataList){
        return calc.performOperation(incomeDataList);
    }

}

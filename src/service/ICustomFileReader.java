package service;

import beans.IncomeData;
import exception.CustomException;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ICustomFileReader {
    List<IncomeData> fetchIncomeData(File file) throws CustomException;

    Map<String, String> readFileAsKeyValue(String path) throws CustomException;
}

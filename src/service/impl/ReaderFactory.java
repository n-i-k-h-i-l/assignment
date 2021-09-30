package service.impl;

import exception.CustomException;
import service.ICustomFileReader;
import service.impl.reader.CSVReader;
import service.impl.reader.JSONReader;

/**
 * Reader Factory is created to demonstrate Factory Design Pattern
 * This class will create Reader Object based on the String passed as a Constructor
 */
public class ReaderFactory {

    private final String reader;

    public ReaderFactory(String reader) {
        this.reader = reader;
    }

    public ICustomFileReader getFileReader() throws CustomException {
        switch (this.reader) {
            case "csv":
                return new CSVReader();
            case "json":
                return new JSONReader();
            default:
                throw new CustomException("File Type not Suppported !!!");
        }
    }
}

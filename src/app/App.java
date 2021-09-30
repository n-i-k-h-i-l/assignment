package app;

import beans.IncomeData;
import beans.ReportData;
import constants.IAppConstants;
import service.IReportService;
import service.impl.ReportService;

import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println(new Date() + " :: Application started !!!");
        IReportService service = ReportService.getInstance();
        try {
            // Reading Data from CSV
            System.out.println(new Date() + " :: Going to fetch Data from CSV !!!");
            List<IncomeData> incomeDataList = service.fetchData(IAppConstants.INPUT_CSV_PATH);
            System.out.println(new Date() + " :: Data fetched from CSV with " + incomeDataList.size() + " records !!!");

            // calculated Average and retrieved OutputBean
            System.out.println(new Date() + " :: Going to calculate income average grouping by Country and Gender !!!");
            List<ReportData> averageIncomeData = service.getAverageIncomeData(incomeDataList);
            System.out.println(new Date() + " :: Average calculated with " + averageIncomeData.size() + " records !!!");

            // write to file
            System.out.println(new Date() + " :: Going to write Data in CSV !!!");
            service.writeDataToFile(IAppConstants.OUTPUT_CSV_PATH, averageIncomeData);
            System.out.println(new Date() + " :: Data successfully inserted in CSV !!!");
        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        System.out.println(new Date() + " :: Exiting Application !!!");
    }

}

package beans;


public class ReportData {

    private String country;

    private String gender;

    private String averageIncome;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(String averageIncome) {
        this.averageIncome = averageIncome;
    }

    @Override
    public String toString() {
        return country + "," + gender + "," + averageIncome;
    }

}

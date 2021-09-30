package beans;


public class IncomeData {

    private String city;

    private String country;

    private String gender;

    private String currency;

    private String averageIncome;

    public IncomeData() {
        super();
    }

    public IncomeData(String city, String country, String gender, String currency, String averageIncome) {
        super();
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.currency = currency;
        this.averageIncome = averageIncome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(String averageIncome) {
        this.averageIncome = averageIncome;
    }

    public IncomeData deepCopy() {
        return new IncomeData(this.city, this.country, this.gender, this.currency, this.averageIncome);
    }
}

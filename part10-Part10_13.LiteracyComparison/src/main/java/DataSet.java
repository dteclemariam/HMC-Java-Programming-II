public class DataSet {
    private String country;
    private int year;
    private String gender;
    private double literacyPercentage;

    public DataSet(String country, int year, String gender, double literacyPercentage){
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.literacyPercentage = literacyPercentage;
    }

    public double getLiteracyPercentage() {
        return literacyPercentage;
    }

    public String toString(){
        return country + " (" + year + "), " + gender + ", " + literacyPercentage;
    }
}

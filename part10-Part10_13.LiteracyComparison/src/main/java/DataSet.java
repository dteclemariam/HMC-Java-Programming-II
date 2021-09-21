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

    //Returning the Object Double as you can use the compareTo method of Double in the stream method in main
    //Another solution is to cast the doubles in the stream to an int after multiplying it with 1000
    public Double getLiteracyPercentage() {
        return literacyPercentage;
    }

    public String toString(){
        return country + " (" + year + "), " + gender + ", " + literacyPercentage;
    }
}


public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public boolean equals(Object compared){
        if (this == compared) return true;
        if (compared == null || this.getClass() != compared.getClass()) return false;

        SimpleDate comparedSimpleDate = (SimpleDate) compared;

        if (this.day != comparedSimpleDate.day) return false;
        if (this.month != comparedSimpleDate.month) return false;
        return this.year == comparedSimpleDate.year;
    }

    @Override
    public int hashCode(){
        int result = this.day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

}

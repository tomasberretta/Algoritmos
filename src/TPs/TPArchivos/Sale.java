package TPs.TPArchivos;

public class Sale {
    String destinationCode;
    int code;
    int amount;
    double priceInDolars;
    int day;
    int month;
    int year;

    public Sale(String destinationCode, int code, int amount, double priceInDolars, int day, int month, int year) {
        this.destinationCode = destinationCode;
        this.code = code;
        this.amount = amount;
        this.priceInDolars = priceInDolars;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public int getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }

    public double getPriceInDolars() {
        return priceInDolars;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}

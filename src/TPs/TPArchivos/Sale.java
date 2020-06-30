package TPs.TPArchivos;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

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

    public Sale(String destinationCode) {
        this.destinationCode = destinationCode;
        this.code = (int)(Math.random()*100);
        this.amount = (int)(Math.random()*100);
        this.priceInDolars = (int)(Math.random()*10);
        this.day = (int)(Math.random()*30);
        this.month = (int)(Math.random()*12);
        this.year = 2020;
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

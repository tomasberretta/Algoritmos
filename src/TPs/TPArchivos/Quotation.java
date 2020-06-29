package TPs.TPArchivos;

import java.io.Serializable;

public class Quotation implements Serializable {
    int month;
    double dollarValue;

    public Quotation(int month, double dollarValue) {
        this.month = month;
        this.dollarValue = dollarValue;
    }

    public int getMonth() {
        return month;
    }

    public double getDollarValue() {
        return dollarValue;
    }
}

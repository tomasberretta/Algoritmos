package TPs.TPArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ExportationsSystem {
    static Destination[] destinations;
    static int n;

    private static String salesFileName = "Sales File";
    private static String quotationFileName = "Quotation File";

    public static void main(String[] args) {
        n = 30;
        String dName = "Destinations File";
        destinations = new Destination[n];

        try {
            DestinationFile destinationFile = new DestinationFile(dName);
            writeDestinations(destinationFile);
            readDestinations(destinationFile);
            QuotationFile qFile = new QuotationFile(quotationFileName);

            generateSalesFile();
            generateQuotationFile(qFile);

            Quotation[] quotations = qFile.getQuotations();

            generateDestinationsReport(quotations);
            generateQuotationReport(quotations);

            qFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    private static void generateQuotationReport(Quotation[] quotations) {
        try {
            Sale s;
            SalesFile fileS = new SalesFile(salesFileName);
            File reportFile = new File("Report by Month");
            FileWriter fW = new FileWriter(reportFile);

            for (int i = 0; i < quotations.length; i++) {
                fW.write("Month: " + (i+1) + "\n");

                double totalPrice = 0;

                Sale[] sales = fileS.searchByMonth(i);
                for (int j = 0; j < sales.length; j++) {
                    if(sales[j] == null) break;
                    if(sales[j] != null) {
                        for (int k = 0; k < quotations.length; k++) {
                            if (quotations[k].getMonth() == sales[j].getMonth()) totalPrice += sales[j].getPriceInDolars()*sales[j].getAmount()*quotations[k].getDollarValue();
                        }
                    }
                }
                fW.write(totalPrice + "\n \n");
            }

            fW.close();
            fileS.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String randomString (){
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        int targetStringLength = 3;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static void generateDestinationsReport(Quotation[] quotations) {
        try {
            Sale s;
            SalesFile fileS = new SalesFile(salesFileName);
            File reportFile = new File("Report by Destination");
            FileWriter fW = new FileWriter(reportFile);

            for (int i = 0; i < destinations.length; i++) {
                String code = destinations[i].getDestinationCode();
                fW.write(code + "\n");

                double totalPrice = 0;

                Sale[] sales = fileS.searchByDestination(code);
                for (int j = 0; j < sales.length; j++) {
                    if(sales[j] == null) break;
                    if(sales[j] != null) {
                        for (int k = 0; k < quotations.length; k++) {
                            if (quotations[k].getMonth() == sales[j].getMonth()) totalPrice += sales[j].getPriceInDolars()*sales[j].getAmount()*quotations[k].getDollarValue();
                        }
                    }
                }
                fW.write(totalPrice + "\n \n");
            }

            fW.close();
            fileS.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void generateSalesFile(){
        try {
            SalesFile fileS = new SalesFile(salesFileName);
            for (int i = 0; i < 1000; i++) {
                int j = (int)(Math.random()*n);
                fileS.write(new Sale(destinations[j].getDestinationCode()));
            }
            fileS.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void generateQuotationFile(QuotationFile qFile){
        try {
            for (int i = 0; i < 12; i++) {
                qFile.write(new Quotation(i, Math.random() * ((100 - 50) + 1) + 50));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeDestinations (DestinationFile dfile){
        try {
            for (int i = 0; i < n; i++) {
                dfile.write(new Destination(randomString(), ""));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void readDestinations (DestinationFile dfile){
        try {
            for (int i = 0; i < n; i++) {
                destinations[i] = dfile.read();
            }
            dfile.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

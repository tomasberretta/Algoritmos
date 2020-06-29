package TPs.TPArchivos;

//todo otros archivos

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ExportationsSystem {
    static Destination[] destinations;
    static int n;

    private static String salesFileName = "Sales File";

    public static void main(String[] args) {
        n = 30;
        String dName = "Destinations File";
        destinations = new Destination[n];

        try {
            DestinationFile destinationFile = new DestinationFile(dName);
            writeDestinations(destinationFile);
            readDestinations(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        generateSalesFile();
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

    public void generateDestinationsReport() {
        try {
            Sale s;
            SalesFile fileS = new SalesFile(salesFileName);
            File reportFile = new File("Report by Destination");

            FileWriter fW = new FileWriter(reportFile);
            long size = fileS.quantReg();
            for (int i = 0; i < destinations.length; i++) {
                fW.write(destinations[i].getDestinationCode() + "\n");
                for (int j = 0; j < size; j++) {
                    //if(fileS.searchByDestination(destinations[i]).equals(destinations[j])){
                        //todo
                    //}
                }
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
            e.printStackTrace();
        }
    }

    public static void writeDestinations (DestinationFile dfile){
        try {
            for (int i = 0; i < n; i++) {
                dfile.write(new Destination(randomString(), ""));
            }
        } catch (IOException e) {
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
            e.printStackTrace();
        }
    }
}

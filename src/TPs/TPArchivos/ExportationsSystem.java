package TPs.TPArchivos;

//todo otros archivos

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class ExportationsSystem {
    static String[] destinations;

    private static String salesFileName = "Sales File";

    public static void main(String[] args) {
        int n = 30;
        destinations = new String[n];
        for (int i = 0; i < n; i++) {
            destinations[i] = randomString();
            for (int j = 0; j < i; j++) {
                if (destinations[i].equals(destinations[j])) {
                    destinations[j] = randomString();
                }
            }
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

    public void generateDestinationsReport() {
        try {
            Sale s;
            SalesFile fileS = new SalesFile(salesFileName);
            File reportFile = new File("Report by Destination");

            FileWriter fW = new FileWriter(reportFile);
            long size = fileS.quantReg();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < destinations.length; j++) {
                    if(fileS.searchByDestination(destinations[i]).equals(destinations[j])){
                        //todo
                    }
                }
            }

            fW.close();
            fileS.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}

package TPs.TP2;

import java.util.Scanner;

public class Blast {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a reference sequence: ");
        String referenceSequence = scanner.nextLine();

        System.out.println("Enter a query sequence: ");
        String querySequence = scanner.nextLine();

        System.out.println("The sequences are " + blast(querySequence, referenceSequence) + "% alike.");
    }

    public static double blast(String querySequence, String referenceSequence) {
        if(querySequence.length() != referenceSequence.length()) throw new RuntimeException("Sequences must have the same length.");

        int counter = 0;
        for (int i = 0; i < referenceSequence.length(); i++) {
            if(referenceSequence.charAt(i) == querySequence.charAt(i)) counter++;
        }
        return counter*100/referenceSequence.length();
    }
}

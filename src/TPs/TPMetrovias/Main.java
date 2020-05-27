package TPs.TPMetrovias;

import java.util.Scanner;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------METROVIAS---------");
        System.out.println("Enter amount of windows: ");
        int numWindow = sc.nextInt();
        while (!(numWindow >= 5 && numWindow <= 25)){
            System.out.println("Please enter a number between 5 and 25: ");
            numWindow = sc.nextInt();
        }
        MSystem msystem = new MSystem(numWindow);
        while (true){
            sc.nextLine();
            System.out.println("---------METROVIAS---------");
            System.out.println("Enter 1 to fast-forward 30 seconds.");
            System.out.println("Enter 2 to end the program.");
            System.out.println("Enter 3 to get total income and mean wait time.");
            int option = sc.nextInt();
            switch(option) {
                case 1 :
                    msystem.forward30sec();
                    break;
                case 2 :
                    msystem.mostrarPila(msystem.getClients());
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("Income: " + msystem.getIncome());
                    System.out.println("Wait time: " + msystem.meanTime());
                    break;
                default :
                    System.out.println("Invalid option");
                    break;
            }
        }

    }


}

package TPs.TPMetrovias;

import java.util.Scanner;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cant ventanillas");
        int numWindow = sc.nextInt();
        MSystem msystem = new MSystem(numWindow);
        while (true){
            sc.nextLine();
            System.out.println("Option");
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
                    System.out.println(msystem.getIncome());
                    System.out.println(msystem.meanTime());
                    break;
                default :
                    System.out.println("Invalid option");
                    break;
            }
        }

    }


}

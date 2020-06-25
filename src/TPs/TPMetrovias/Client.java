package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Client {
    int ticketNumber;
    int waitTime;

    public Client(){
        waitTime = 0;
        // Asigna un número de ticket random entre 10000 y 100000 para que sea de 5 dígitos
        ticketNumber = (int)(Math.random() * ((100000 - 10000) + 1)) + 10000;
    }

    public void increaseWaitTime() {
        waitTime += 30;
    }

    public int getWaitTime() {
        return waitTime;
    }
}

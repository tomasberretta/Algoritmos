package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Client {
    int ticketNumber;
    int waitTime;

    public Client(){
        waitTime = 0;
        ticketNumber = (int)(Math.random() * ((100000 - 10000) + 1)) + 10000;
    }
}

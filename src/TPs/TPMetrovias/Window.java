package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Window {
    QueueD<Client> clientsWaiting;
    double totalAmount;

    public Window (){
        clientsWaiting = new QueueD<>();
        totalAmount = 0;
    }
}

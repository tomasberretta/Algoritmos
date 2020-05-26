package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Window {
    QueueD<Client> clientsWaiting;
    double totalIncome;

    public Window (){
        clientsWaiting = new QueueD<>();
        totalIncome = 0;
    }

    public void enqueueClient(Client toAssign){
        clientsWaiting.enqueue(toAssign);
    }

    public Client dequeueClient() {
        Client toDequeue = clientsWaiting.dequeue();
        totalIncome += 5; //adds 5 pesos to total amount
        return toDequeue;
    }

    public void increaseWaitTimeClients (){
        QueueD <Client> temp = new QueueD<>();
        for (int i = 0; i < clientsWaiting.size; i++) {
            Client toDequeue = clientsWaiting.dequeue();
            toDequeue.increaseWaitTime();
            temp.enqueue(toDequeue);
        }
        clientsWaiting = temp;
    }

    public boolean isEmpty (){
        return clientsWaiting.isEmpty();
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}

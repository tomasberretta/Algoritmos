package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Window {
    QueueD<Client> clientsWaiting;
    StackD<Client> clientsAttended;
    double totalIncome;

    public Window (){
        clientsWaiting = new QueueD<>();
        clientsAttended = new StackD<>();
        totalIncome = 0;
    }

    public void enqueueClient(Client toAssign){
        clientsWaiting.enqueue(toAssign);
    }

    public Client dequeueClient() {
        Client toDequeue = clientsWaiting.dequeue();
        totalIncome += 5; // Suma 5 al total recaudado (valor no especificado por la consigna)
        clientsAttended.push(toDequeue); // Agrega el cliente a la pila de clientes atendidos
        return toDequeue;
    }

    public void increaseWaitTimeClients (){
        // Desencola todos los clientes, les aumenta su tiempo de espera y los encola en otra cola.
        QueueD <Client> temp = new QueueD<>();
        for (int i = 0; i < clientsWaiting.size; i++) {
            Client toDequeue = clientsWaiting.dequeue();
            toDequeue.increaseWaitTime();
            temp.enqueue(toDequeue);
        }
        clientsWaiting = temp; // Asigna la cola temporal a la de los clientes, para que no haya modificaciones
    }

    public double getMeanWatingTime(){
        // Toma todos los clientes y va sumando su tiempo de espera, luego hace ese contador divido la cantidad de clientes
        StackD<Client> temp = new StackD<>();
        double counter = 0;
        int clientsSize = clientsAttended.size;
        for (int i = 0; i < clientsSize; i++) {
            if(!clientsAttended.isEmpty()){
                Client toPop = clientsAttended.peek();
                temp.push(toPop);
                counter += toPop.getWaitTime();
                clientsAttended.pop();
            }
        }
        clientsAttended = temp;
        return counter/clientsAttended.size;
    }

    public boolean isEmpty (){
        return clientsWaiting.isEmpty();
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}

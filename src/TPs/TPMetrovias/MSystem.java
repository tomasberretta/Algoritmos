package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class MSystem {
    Window[] windows;
    StackD<Client> clients;

    public MSystem(int n){
        windows = new Window[n];
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new Window();
        }
        clients = new StackD<>();
    }

    public QueueD<Double> getMeanTime (){
        QueueD<Double> meanTimeWindows = new QueueD<>();
        for (Window window : windows) {
            meanTimeWindows.enqueue(window.getMeanWatingTime());
        }
        return meanTimeWindows;
    }

    public QueueD<Double> getIncome () {
        QueueD<Double> incomeWindows = new QueueD<>();
        for (Window window : windows) {
            incomeWindows.enqueue(window.getTotalIncome());
        }
        return incomeWindows;
    }

    public void forward30sec() {
        /*
         Si la ventanilla no esta vacía hay un 50% de que se atienda la persona que esta primera en la cola.
         Luego se encolan en ventanillas al azar 5 personas nuevas.
         */
        for (Window window : windows) {
            if (!window.isEmpty()) {
                window.increaseWaitTimeClients();
                if (((int) (Math.random() * ((2 - 1) + 1)) + 1) == 1) {
                    clients.push(window.dequeueClient());
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            windows[(int)(Math.random() * ((windows.length-1) + 1))].enqueueClient(new Client());
        }

    }

    //no hacer
    public void mostrarPila(StackD<Client> p){
    }

    public StackD<Client> getClients() {
        return clients;
    }
}

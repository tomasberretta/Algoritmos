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

    public int meanTime (){
        StackD<Client> temp = new StackD<>();
        int counter = 0;
        for (int i = 0; i < clients.size; i++) {
            if(!clients.isEmpty()){
                Client toPop = clients.peek();
                temp.push(toPop);
                counter += toPop.getWaitTime();
                clients.pop();
            }
        }
        clients = temp;
        return counter/clients.size;
    }

    public int getIncome () {
        int income = 0;
        for (Window window : windows) {
            income += window.getTotalIncome();
        }
        return income;
    }

    public void forward30sec() {
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

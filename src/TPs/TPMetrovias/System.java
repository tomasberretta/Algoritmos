package TPs.TPMetrovias;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class System {
    Window[] windows;
    StackD<Client> clients;

    public System (int n){
        windows = new Window[n];
        clients = new StackD<>();
    }

    //todo meanTime
    public void meanTime (){
    }
}

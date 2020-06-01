package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class AVLNode<T>{
    int height;
    T data;
    AVLNode<T> left, right;

    AVLNode(T data) {
        this.data = data;
        height = 1;
    }
}

package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

class DoubleNode<T>{
    int height;
    T data;
    DoubleNode <T> left, right;

    DoubleNode(T data) {
        this.data = data;
        height = 1;
    }
}

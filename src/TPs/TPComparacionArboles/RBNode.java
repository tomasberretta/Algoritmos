package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class RBNode<T> {

    T data;
    RBNode<T> left;
    RBNode<T> right;
    int color; // black = 1, red = 0

    RBNode(T data ) {
        this( data, null, null );
    }

    RBNode(T data, RBNode<T> leftNode, RBNode<T> rightNode ) {
        this.data = data;
        left     = leftNode;
        right    = rightNode;
        color    = 1; //black
    }

}

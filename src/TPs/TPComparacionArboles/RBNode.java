package TPs.TPComparacionArboles;

public class RBNode<T> {

    T element;
    RBNode<T> left;
    RBNode<T> right;
    int color; // black = 1, red = 0

    RBNode(T theElement ) {
        this( theElement, null, null );
    }

    RBNode(T theElement, RBNode<T> lt, RBNode<T> rt ) {
        element  = theElement;
        left     = lt;
        right    = rt;
        color    = 1; //black
    }

}

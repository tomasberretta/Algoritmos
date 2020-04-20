package TPs.TP5;

/**
 *@author Tomas Berretta
 **/

public class DoubleNode <T> {
    T data;
    DoubleNode <T> right, left;

    public DoubleNode (T o){
        data = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        data = o;
        this.right = right;
        this.left = left;
    }
}

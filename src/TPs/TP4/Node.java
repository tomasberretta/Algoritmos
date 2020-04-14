package TPs.TP4;

public class Node<T> {
    T data;
    Node<T> pointer;

    public Node(T newData){
        data = newData;
    }

    public Node(T newData,Node<T> newPointer ){
        data = newData;
        pointer = newPointer;
    }

    public Node() {
        data = null;
        pointer = null;
    }
}
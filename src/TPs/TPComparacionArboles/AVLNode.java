package TPs.TPComparacionArboles;

public class AVLNode<T>{
    int height;
    T data;
    AVLNode<T> left, right;

    AVLNode(T data) {
        this.data = data;
        height = 1;
    }
}

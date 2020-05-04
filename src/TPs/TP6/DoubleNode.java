package TPs.TP6;

class DoubleNode<T>{
    int height;
    T data;
    DoubleNode left, right;

    DoubleNode(T data) {
        this.data = data;
        height = 1;
    }
}

package TPs.TP6;

public class DoubleNodeAVL <T>{
    int height;
    T data;
    DoubleNodeAVL <T> right, left;

    public DoubleNodeAVL(T o) {
        data = o;
        height = 1;
    }
    public DoubleNodeAVL(T o, DoubleNodeAVL<T> left, DoubleNodeAVL<T> right){
        data = o;
        this.right = right;
        this.left = left;
        height = 1;
    }

}

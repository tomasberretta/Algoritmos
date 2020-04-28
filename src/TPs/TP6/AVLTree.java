package TPs.TP6;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

class AVLTree<T> {

    DoubleNodeAVL<T> root;

    public AVLTree(){
        root = null;
    }

    public AVLTree(T o){
        root = new DoubleNodeAVL<>(o);
    }

    public AVLTree(T o, AVLTree<T> tleft, AVLTree<T> tright){
        root = new DoubleNodeAVL<>(o, tleft.root, tright.root);
    }

    public T getRootData(){
        return root.data;
    }

    public DoubleNodeAVL<T> getRootNode(){
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public AVLTree<T> getLeft() {
        AVLTree<T> t = new AVLTree<>();
        t.root = root.left;
        return t;
    }

    public AVLTree<T> getRight() {
        AVLTree<T> t = new AVLTree<>();
        t.root = root.right;
        return t;
    }

    int height(AVLTree<T> avlTree) {
        if (avlTree.isEmpty())
            return 0;

        return avlTree.getRootNode().height;
    }

    AVLTree<T> rightRotate(AVLTree<T> y) {
        AVLTree<T> x = y.getLeft();
        AVLTree<T> z = x.getRight();

        // Perform rotation
        y.getRootNode().left = z.getRootNode(); //todo ver bien wtf
        x.getRootNode().right = y.getRootNode();

        // Update heights
        y.getRootNode().height = Math.max(height(y.getLeft()), height(y.getRight())) + 1;
        x.getRootNode().height = Math.max(height(x.getLeft()), height(x.getRight())) + 1;

        // Return new root
        return x;
    }

    AVLTree<T> leftRotate(AVLTree<T> x) {
        AVLTree<T> y = x.getRight();
        AVLTree<T> z = y.getLeft();

        // Perform rotation
        x.getRootNode().right = z.getRootNode();
        y.getRootNode().left = x.getRootNode();  //todo ver bien wtf

        // Update heights
        x.getRootNode().height = Math.max(height(x.getLeft()), height(x.getRight())) + 1;
        y.getRootNode().height = Math.max(height(y.getLeft()), height(y.getRight())) + 1;

        // Return new root
        return y;
    }
}














//puto el que lee
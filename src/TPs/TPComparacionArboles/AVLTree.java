package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

class AVLTree <T extends Comparable<T>>{

    DoubleNode<T> root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(DoubleNode<T> root) {
        this.root = root;
    }

    AVLTree<T> getLeft() {
        return new AVLTree<>(root.left);
    }
    AVLTree<T> getRight() {
        return new AVLTree<>(root.right);
    }

    int getHeight(DoubleNode<T> doubleNode) {
        if (doubleNode == null)
            return 0;
        return doubleNode.height;
    }

    int getBalance(DoubleNode<T> doubleNode) {
        if (doubleNode == null) return 0;
        return getHeight(doubleNode.left) - getHeight(doubleNode.right);
    }

    DoubleNode<T> rightRotation(DoubleNode<T> y) {
        DoubleNode<T> x = y.left;
        DoubleNode<T> z = x.right;
        x.right = y;
        y.left = z;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    DoubleNode<T> leftRotation(DoubleNode<T> x) {
        DoubleNode<T> y = x.right;
        DoubleNode<T> z = y.left;
        y.left = x;
        x.right = z;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    T search(T data){
        return search(this.root, data);
    }

    private T search (DoubleNode<T> doubleNode, T data){
        if (doubleNode == null) return null;
        if(data.compareTo(doubleNode.data) < 0) return (T) search(doubleNode.left, data);
        else if (data.compareTo(doubleNode.data) > 0) return (T) search(doubleNode.right, data);
        else if(data.compareTo(doubleNode.data) == 0) return doubleNode.data;
        return null;
    }

    boolean isInTree(T data){
        return isInTree(this.root, data);
    }

    private boolean isInTree(DoubleNode<T> doubleNode, T data){
        if (doubleNode == null) return false;
        if(doubleNode.data == null) return false;
        if(data.compareTo(doubleNode.data) < 0) return isInTree(doubleNode.left, data);
        if (data.compareTo(doubleNode.data) > 0) return isInTree(doubleNode.right, data);
        if(data.compareTo(doubleNode.data) == 0) return true;
        return false;
    }

    void insert (T data){
        this.root = this.insert(this.root, data);
    }

    private DoubleNode<T> insert(DoubleNode<T> doubleNode, T data) {
        if (doubleNode == null)
            return (new DoubleNode<T>(data));
        if (data.compareTo((T)doubleNode.data) < 0)
            doubleNode.left = insert(doubleNode.left, data);
        else if (data.compareTo((T) doubleNode.data) > 0)
            doubleNode.right = insert(doubleNode.right, data);
        else
            return doubleNode;
        doubleNode.height = 1 + Math.max(getHeight(doubleNode.left),
                getHeight(doubleNode.right));
        int balance = getBalance(doubleNode);
        //Left Case
        if (balance > 1 && data.compareTo((T) doubleNode.left.data) < 0)
            return rightRotation(doubleNode);
        //Right Case
        if (balance < -1 && data.compareTo((T) doubleNode.right.data) > 0)
            return leftRotation(doubleNode);
        //Left Elbow Case
        if (balance > 1 && data.compareTo((T) doubleNode.left.data) > 0) {
            doubleNode.left = leftRotation(doubleNode.left);
            return rightRotation(doubleNode);
        }
        //Right Elbow Case
        if (balance < -1 && data.compareTo((T) doubleNode.right.data) < 0) {
            doubleNode.right = rightRotation(doubleNode.right);
            return leftRotation(doubleNode);
        }
        return doubleNode;
    }

    DoubleNode<T> minValueNode(DoubleNode<T> doubleNode){
        DoubleNode<T> current = doubleNode;
        while (current.left != null)
            current = current.left;
        return current;
    }

    void delete (T data){
        this.root = this.delete(this.root, data);
    }

    private DoubleNode<T> delete(DoubleNode<T> doubleNode, T data) {
        if (doubleNode == null)
            return doubleNode;
        if (data.compareTo(doubleNode.data) < 0)
            doubleNode.left = delete(doubleNode.left, data);
        else if (data.compareTo((T) doubleNode.data) > 0)
            doubleNode.right = delete(doubleNode.right, data);
        else {
            if ((doubleNode.left == null) || (doubleNode.right == null)) {
                DoubleNode<T> temp = null;
                if (temp == doubleNode.left)
                    temp = doubleNode.right;
                else
                    temp = doubleNode.left;

                if (temp == null) {
                    temp = doubleNode;
                    doubleNode = null;
                }
                else
                    doubleNode = temp;
            }
            else {
                DoubleNode<T> temp = minValueNode(doubleNode.right);
                doubleNode.data = temp.data;
                doubleNode.right = delete(doubleNode.right, (T) temp.data);
            }
        }
        if (doubleNode == null)
            return doubleNode;
        doubleNode.height = Math.max(getHeight(doubleNode.left), getHeight(doubleNode.right)) + 1;
        int balance = getBalance(doubleNode);
        if (balance > 1 && getBalance(doubleNode.left) >= 0)
            return rightRotation(doubleNode);
        if (balance > 1 && getBalance(doubleNode.left) < 0){
            doubleNode.left = leftRotation(doubleNode.left);
            return rightRotation(doubleNode);
        }
        if (balance < -1 && getBalance(doubleNode.right) <= 0)
            return leftRotation(doubleNode);
        if (balance < -1 && getBalance(doubleNode.right) > 0) {
            doubleNode.right = rightRotation(doubleNode.right);
            return leftRotation(doubleNode);
        }
        return doubleNode;
    }

    public boolean isEmpty(){
        return root == null;
    }

}


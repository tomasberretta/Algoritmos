package TPs.TP6;

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

    int height(DoubleNode<T> doubleNode) {
        if (doubleNode == null)
            return 0;
        return doubleNode.height;
    }

    DoubleNode<T> rightRotate(DoubleNode<T> y) {
        DoubleNode<T> x = y.left;
        DoubleNode<T> z = x.right;
        x.right = y;
        y.left = z;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    DoubleNode<T> leftRotate(DoubleNode<T> x) {
        DoubleNode<T> y = x.right;
        DoubleNode<T> z = y.left;
        y.left = x;
        x.right = z;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalance(DoubleNode<T> doubleNode) {
        if (doubleNode == null) return 0;
        return height(doubleNode.left) - height(doubleNode.right);
    }

    T search(T data){
        return search(this.root, data);
    }

    T search (DoubleNode<T> doubleNode, T data){
        if (doubleNode == null) return null;
        if(data.compareTo(doubleNode.data) < 0) return (T) search(doubleNode.left, data);
        else if (data.compareTo(doubleNode.data) > 0) return (T) search(doubleNode.right, data);
        else if(data.compareTo(doubleNode.data) == 0) return doubleNode.data;
        return null;
    }

    boolean isInTree(T data){
        return isInTree(this.root, data);
    }

    boolean isInTree(DoubleNode<T> doubleNode, T data){
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

    DoubleNode<T> insert(DoubleNode<T> doubleNode, T data) {
        if (doubleNode == null)
            return (new DoubleNode<T>(data));
        if (data.compareTo((T)doubleNode.data) < 0)
            doubleNode.left = insert(doubleNode.left, data);
        else if (data.compareTo((T) doubleNode.data) > 0)
            doubleNode.right = insert(doubleNode.right, data);
        else
            return doubleNode;
        doubleNode.height = 1 + Math.max(height(doubleNode.left),
                height(doubleNode.right));
        int balance = getBalance(doubleNode);
        //Left Case
        if (balance > 1 && data.compareTo((T) doubleNode.left.data) < 0)
            return rightRotate(doubleNode);
        //Right Case
        if (balance < -1 && data.compareTo((T) doubleNode.right.data) > 0)
            return leftRotate(doubleNode);
        //Left Elbow Case
        if (balance > 1 && data.compareTo((T) doubleNode.left.data) > 0) {
            doubleNode.left = leftRotate(doubleNode.left);
            return rightRotate(doubleNode);
        }
        //Right Elbow Case
        if (balance < -1 && data.compareTo((T) doubleNode.right.data) < 0) {
            doubleNode.right = rightRotate(doubleNode.right);
            return leftRotate(doubleNode);
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

    DoubleNode<T> delete(DoubleNode<T> node, T data) {
        if (node == null)
            return node;
        if (data.compareTo(node.data) < 0)
            node.left = delete(node.left, data);
        else if (data.compareTo((T) node.data) > 0)
            node.right = delete(node.right, data);
        else {
            if ((node.left == null) || (node.right == null)) {
                DoubleNode<T> temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null) {
                    temp = node;
                    node = null;
                }
                else
                    node = temp;
            }
            else {
                DoubleNode<T> temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, (T) temp.data);
            }
        }
        if (node == null)
            return node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        if (balance > 1 && getBalance(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    AVLTree<T> getLeft() {
        return new AVLTree<>(root.left);
    }
    AVLTree<T> getRight() {
        return new AVLTree<>(root.right);
    }

    public boolean isEmpty(){
        return root == null;
    }

}


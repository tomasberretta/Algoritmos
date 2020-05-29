package TPs.TPComparacionArboles;

import Tareas.Arboles.BinaryTree;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class BinarySearchTree <T>{

    private DoubleNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public T getRoot(){
        return root.data;
    }

    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> binarySearchTree = new BinarySearchTree<T>();
        binarySearchTree.root = root.left;
        return binarySearchTree;
    }

    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> binarySearchTree = new BinarySearchTree<T>();
        binarySearchTree.root = root.right;
        return binarySearchTree;
    }

    public T getMax(){
        return getMax(root).data;
    }

    private DoubleNode<T> getMax(DoubleNode <T> doubleNode){
        if (doubleNode.right == null)
            return doubleNode;
        else
            return getMax(doubleNode.right);
    }

    public T getMin(){
        return getMin(root).data;
    }

    private DoubleNode <T> getMin(DoubleNode <T> doubleNode){
        if (doubleNode.left == null)
            return doubleNode;
        else
            return getMin(doubleNode.left);
    }

    public boolean isInTree(Comparable<T> data){
        return isInTree(root, data);
    }

    private boolean isInTree(DoubleNode <T> doubleNode, Comparable<T> data) {
        if (doubleNode == null)
            return false;
        if (data.compareTo(doubleNode.data) == 0)
            return true;
        else if (data.compareTo( doubleNode.data)< 0)
            return isInTree(doubleNode.left, data);
        else
            return isInTree(doubleNode.right, data);
    }
    public T search(Comparable<T> data){
        return search(root, data).data;
    }
    private DoubleNode <T> search(DoubleNode <T> doubleNode, Comparable<T> data){
        if (data.compareTo(doubleNode.data)== 0)
            return doubleNode;
        else if (data.compareTo( doubleNode.data)< 0)
            return search(doubleNode.left, data);
        else
            return search(doubleNode.right, data);
    }

    public void insert(Comparable <T> data){
        root = insert(root, data);
    }
    private DoubleNode<T> insert (DoubleNode <T> doubleNode, Comparable <T> data) {
        if (doubleNode == null){
            doubleNode = new DoubleNode<T>((T)data);
        }
        else if (data.compareTo(doubleNode.data) < 0)
            doubleNode.left = insert(doubleNode.left, data);
        else
            doubleNode.right = insert(doubleNode.right, data);
        return doubleNode;
    }
    public void delete(Comparable <T> data){
        root = delete(root, data);
    }
    private DoubleNode<T> delete (DoubleNode<T> doubleNode, Comparable<T> data) {
        if (data.compareTo(doubleNode.data) < 0)
            doubleNode.left = delete(doubleNode.left, data);
        else if (data.compareTo(doubleNode.data) > 0)
            doubleNode.right = delete(doubleNode.right, data);
        else
        if (doubleNode.left != null && doubleNode.right != null ) {
            doubleNode.data = getMin(doubleNode.right).data;
            doubleNode.right = deleteMin(doubleNode.right);
        }
        else if (doubleNode.left != null)
            doubleNode = doubleNode.left;
        else
            doubleNode =doubleNode.right;
        return doubleNode;
    }
    private DoubleNode<T> deleteMin(DoubleNode<T> doubleNode){
        if (doubleNode.left != null)
            doubleNode.left = deleteMin(doubleNode.left);
        else
            doubleNode = doubleNode.right;
        return doubleNode;
    }

    public int height (BinarySearchTree<T> binarySearchTree){
        if (binarySearchTree.isEmpty()) return -1;
        else if(binarySearchTree.getLeft().isEmpty() && binarySearchTree.getRight().isEmpty()) return 1 ;
        else if(binarySearchTree.getRight().isEmpty()) return 1 + height(binarySearchTree.getLeft());
        else if(binarySearchTree.getLeft().isEmpty()) return 1 + height(binarySearchTree.getRight());
        else {
            int hLeft = height(binarySearchTree.getLeft());
            int hRight = height(binarySearchTree.getRight());

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft; //both are the same height
        }
    }
}


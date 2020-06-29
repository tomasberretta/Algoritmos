package TPs.TP5;

import java.util.ArrayList;
import java.util.HashSet;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class TPBinaryTrees <T>{

    public int weight (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) return 0;
        else return 1 + weight(aBinaryTree.getLeft()) + weight(aBinaryTree.getRight());
    }

    public int numberOfLeaves (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) return 0;
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()) return 1;
        else return (numberOfLeaves(aBinaryTree.getLeft()) + numberOfLeaves(aBinaryTree.getRight()));
    }

    public int numberOfElementsAtLevel (BinaryTree<T> aBinaryTree, int level){
        if (aBinaryTree.isEmpty()) return 0;
        if(level == 0) return 1;
        if (level == 1) {
            if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()) return 0;
            else if(aBinaryTree.getRight().isEmpty()) return 1;
            else if(aBinaryTree.getLeft().isEmpty()) return 1;
            else return 2;
        }
        return numberOfElementsAtLevel(aBinaryTree.getLeft(), level-1) + numberOfElementsAtLevel(aBinaryTree.getRight(), level-1);
    }

    public int appearencesOfElement (BinaryTree<T> aBinaryTree, T element){
        if(aBinaryTree.isEmpty()) return 0;
        else if(aBinaryTree.getRoot().equals(element)) return 1 + appearencesOfElement(aBinaryTree.getLeft(), element) + appearencesOfElement(aBinaryTree.getRight(), element);
        else return appearencesOfElement(aBinaryTree.getLeft(), element) + appearencesOfElement(aBinaryTree.getRight(), element);
    }

    public int height(BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) return -1;
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()) return 1 ;
        else if(aBinaryTree.getRight().isEmpty()) return 1 + height(aBinaryTree.getLeft());
        else if(aBinaryTree.getLeft().isEmpty()) return 1 + height(aBinaryTree.getRight());
        else {
            int hLeft = height(aBinaryTree.getLeft());
            int hRight = height(aBinaryTree.getRight());

            if(hLeft > hRight) return 1 + hLeft;
            else if (hLeft < hRight) return 1 + hRight;
            else return 1 + hLeft; //both are the same height
        }
    }

    public int sumOfElements(BinaryTree<Integer> aBinaryTree){
        int result = 0;
        if (aBinaryTree.isEmpty()) return result;
        else{
            result += aBinaryTree.getRoot();
            result += sumOfElements(aBinaryTree.getLeft());
            result += sumOfElements(aBinaryTree.getRight());
            return result;
        }
    }

    public int sumOfElementsMult3(BinaryTree<Integer> aBinaryTree){
        int result = 0;
        if (aBinaryTree.isEmpty()) return result;
        else{
            if(aBinaryTree.getRoot() % 3 == 0){
                result += aBinaryTree.getRoot();
            }
            result += sumOfElementsMult3(aBinaryTree.getLeft());
            result += sumOfElementsMult3(aBinaryTree.getRight());

            return result;
        }
    }

    public boolean areTreesEqual (BinaryTree<T> aBinaryTree, BinaryTree<T> anotherBinaryTree){
        if(aBinaryTree.isEmpty() && (anotherBinaryTree.isEmpty())) return true;
        else if(aBinaryTree.isEmpty() || anotherBinaryTree.isEmpty()) return false;
        else if(aBinaryTree.getRoot().equals(anotherBinaryTree.getRoot())){
            return (areTreesEqual(aBinaryTree.getLeft(), anotherBinaryTree.getLeft()) && areTreesEqual(aBinaryTree.getRight(), anotherBinaryTree.getRight()));
        }else return false;
    }

    public boolean areTreesIsomorphic(BinaryTree<T> aBinaryTree, BinaryTree<T> anotherBinaryTree){
        if(aBinaryTree.isEmpty() && (anotherBinaryTree.isEmpty())) return true;
        else if(aBinaryTree.isEmpty() || anotherBinaryTree.isEmpty()) return false;
        else return (areTreesIsomorphic(aBinaryTree.getLeft(), anotherBinaryTree.getLeft()) && areTreesIsomorphic(aBinaryTree.getRight(), anotherBinaryTree.getRight()));

    }

    public boolean areTreesAlike (BinaryTree<T> aBinaryTree, BinaryTree<T> anotherBinaryTree){
        if(aBinaryTree.isEmpty() && (anotherBinaryTree.isEmpty())) return true;
        else if(aBinaryTree.isEmpty()||anotherBinaryTree.isEmpty() ) return false;
        else return (setOfElements(aBinaryTree).containsAll(setOfElements(anotherBinaryTree)));

    }
    public HashSet<T> setOfElements (BinaryTree<T> aBinaryTree, HashSet<T> setOfElements){
        if (aBinaryTree.isEmpty()) return setOfElements;
        else if (aBinaryTree.getRight().isEmpty() && aBinaryTree.getLeft().isEmpty()){
            setOfElements.add(aBinaryTree.getRoot());
            return setOfElements;
        }else if(aBinaryTree.getRight().isEmpty()){
            setOfElements.add(aBinaryTree.getRoot());
            return setOfElements(aBinaryTree.getLeft(), setOfElements);
        }else if(aBinaryTree.getLeft().isEmpty()){
            setOfElements.add(aBinaryTree.getRoot());
            return setOfElements(aBinaryTree.getRight(), setOfElements);
        }else{
            setOfElements.add(aBinaryTree.getRoot());
            return setOfElements(aBinaryTree.getRight(), setOfElements(aBinaryTree.getLeft(), setOfElements));
        }

    }

    public HashSet<T> setOfElements (BinaryTree<T> aBinaryTree){
        return setOfElements(aBinaryTree, new HashSet<>());
    }

    public boolean isComplete (BinaryTree<T> aBinaryTree){
        if(aBinaryTree.isEmpty()) return false;
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()) return true;
        else if(aBinaryTree.getRight().isEmpty() || aBinaryTree.getLeft().isEmpty()) return false;
        else return isComplete(aBinaryTree.getLeft()) && isComplete(aBinaryTree.getRight());
    }

    public boolean isFull (BinaryTree<T> aBinaryTree){
        if(aBinaryTree.isEmpty()) return false;
        else return height(aBinaryTree.getRight()) == height(aBinaryTree.getLeft()) && isComplete(aBinaryTree);

    }

    public boolean isStable (BinaryTree<Comparable<T>> aBinaryTree){
        if (aBinaryTree.isEmpty()) return true;
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()) return true ;
        else if (aBinaryTree.getRoot().compareTo((T)aBinaryTree.getLeft().getRoot()) > 0 &&
                aBinaryTree.getRoot().compareTo((T)aBinaryTree.getRight().getRoot()) > 0){
            return isStable(aBinaryTree.getLeft()) && isStable(aBinaryTree.getRight());
        }
        else return false;
    }

    public boolean isTreeInTree (BinaryTree<T> aBinaryTree, BinaryTree<T> anotherBinaryTree){
        if(aBinaryTree.isEmpty() && (anotherBinaryTree.isEmpty())) return true;
        else if(aBinaryTree.isEmpty()||anotherBinaryTree.isEmpty()) return false;
        else if(aBinaryTree.getRoot().equals(anotherBinaryTree.getRoot())){
            return (areTreesEqual(aBinaryTree.getLeft(), anotherBinaryTree.getLeft()) && areTreesEqual(aBinaryTree.getRight(), anotherBinaryTree.getRight()));
        }else return isTreeInTree(aBinaryTree.getRight(), anotherBinaryTree)||isTreeInTree(aBinaryTree.getLeft(), anotherBinaryTree);
    }

    public void showFrontier (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) System.out.println("");
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()){
            System.out.println(aBinaryTree.getRoot());
        }
        else{
            showFrontier(aBinaryTree.getLeft());
            showFrontier(aBinaryTree.getRight());
        }
    }

    public ArrayList<T> frontier (BinaryTree<T> aBinaryTree, ArrayList<T> frontierElements){
        if (aBinaryTree.isEmpty()) System.out.println("");
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()){
            frontierElements.add(aBinaryTree.getRoot());
        }
        else{
            frontier(aBinaryTree.getLeft(), frontierElements);
            frontier(aBinaryTree.getRight(), frontierElements);
        }
        return frontierElements;
    }

    public void showPreOrden (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) System.out.println("");
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()){
            System.out.println(aBinaryTree.getRoot());
        }
        else{
            System.out.println(aBinaryTree.getRoot());
            showPreOrden(aBinaryTree.getLeft());
            showPreOrden(aBinaryTree.getRight());
        }
    }

    public void showInOrden (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) System.out.println("");
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()){
            System.out.println(aBinaryTree.getRoot());
        }
        else{
            showInOrden(aBinaryTree.getLeft());
            System.out.println(aBinaryTree.getRoot());
            showInOrden(aBinaryTree.getRight());
        }
    }

    public void showPostOrden (BinaryTree<T> aBinaryTree){
        if (aBinaryTree.isEmpty()) System.out.println("");
        else if(aBinaryTree.getLeft().isEmpty() && aBinaryTree.getRight().isEmpty()){
            System.out.println(aBinaryTree.getRoot());
        }
        else{
            showPostOrden(aBinaryTree.getLeft());
            showPostOrden(aBinaryTree.getRight());
            System.out.println(aBinaryTree.getRoot());
        }
    }

    public void showByLevels(BinaryTree<T> aBinaryTree){
        showByLevels(aBinaryTree, height(aBinaryTree));
    }

    public void showByLevels(BinaryTree<T> aBinaryTree, int height) {
        for (int i=1; i<=height; i++) {
            printGivenLevel( aBinaryTree, i);
            System.out.println();
        }
    }

    public void printGivenLevel(BinaryTree<T> aBinaryTree, int level) {
        if (aBinaryTree.isEmpty())return;
        if (level == 1) System.out.println(aBinaryTree.getRoot());
        else if (level > 1) {
            printGivenLevel(aBinaryTree.getLeft(), level-1);
            printGivenLevel(aBinaryTree.getRight(), level-1);
        }
    }


}

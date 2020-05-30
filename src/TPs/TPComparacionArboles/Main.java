package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Main {

    public static void main(String[] args) {
        int[] arrayNumbers = generateRandomIntArray(1000);
        AVLTree<Integer> AVLTree = generateAVLTree(arrayNumbers);
        System.out.println("AVL Height: " + AVLTree.getHeight());
        BinarySearchTree<Integer> BSTree = generateBSTree(arrayNumbers);
        System.out.println("BS Height: " +BSTree.height());
        RBTree<Integer> RBTree = generateRedBlackTree(arrayNumbers);
        System.out.println("RedBlack Height: " + RBTree.height());
    }

    public static int[] generateRandomIntArray (int n){
        int[] arrayNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            arrayNumbers[i] = (int)(Math.random()* ((100000 - 1) + 1)) + 1;

            for (int j = 0; j < i; j++) {
                if (arrayNumbers[i] == arrayNumbers[j]) {
                    arrayNumbers[j] = (int)(Math.random()* ((100000 - 1) + 1)) + 1;
                }
            }
        }
        return arrayNumbers;
    }

    private static BinarySearchTree<Integer> generateBSTree(int[] intArray) {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            bsTree.insert(value);
        }
        System.out.println(System.nanoTime() - startTime + " nanoseconds to build BSTree");
        return bsTree;
    }

    public static AVLTree<Integer> generateAVLTree (int[] intArray){
        AVLTree<Integer> AVLTree = new AVLTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            AVLTree.insert(value);
        }
        System.out.println(System.nanoTime() - startTime + " nanoseconds to build AVLTree");
        return AVLTree;
    }

    public static RBTree<Integer> generateRedBlackTree (int[] intArray){
        RBTree<Integer> RBTree = new RBTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            RBTree.insert(value);
        }
        System.out.println(System.nanoTime() - startTime + " nanoseconds to build RedBlackTree");
        return RBTree;
    }

}

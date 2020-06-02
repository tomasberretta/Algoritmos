package TPs.TPComparacionArboles;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Main {

    static long[] timesAVL;
    static long[] timesBS;
    static long[] timesRB;
    static long[] triesAVL;
    static long[] triesBS;
    static long[] triesRB;
    static long[] heightsAVL;
    static long[] heightsBS;
    static long[] heightsRB;
    static double[] averageTriesAVL;
    static double[] averageTriesBS;
    static double[] averageTriesRB;


    public static void main(String[] args) {
        initializeArrays(10);
        doExercise(1); //can be changed to 10 to repeat exercise, avl may fail sometimes if so run again.
    }

    public static void initializeArrays(int n){
        timesAVL = new long[n];
        timesBS = new long[n];
        timesRB = new long[n];
        triesAVL = new long[n];
        triesBS = new long[n];
        triesRB = new long[n];
        heightsAVL = new long[n];
        heightsBS = new long[n];
        heightsRB = new long[n];
        averageTriesAVL = new double[n];
        averageTriesBS = new double[n];
        averageTriesRB = new double[n];
    }

    public static void doExercise(int n){

        for (int i = 0; i < n; i++) {
            if(i != 0) System.out.println("\n"+"Repetition number: " + i + "\n");
            int[] arrayNumbers = generateRandomIntArray(1000);
            AVLTree<Integer> AVLTree = generateAVLTree(arrayNumbers, i);
            System.out.println("Time to construct AVL Tree: " + timesAVL[i] + " nanoseconds");
            System.out.println("AVL Height: " + heightInAVLTree(AVLTree,i));
            BinarySearchTree<Integer> BSTree = generateBSTree(arrayNumbers, i);
            System.out.println("Time to construct BS Tree: " + timesBS[i]+ " nanoseconds");
            System.out.println("BS Height: " +heightInBSTree(BSTree,i));
            RBTree<Integer> RBTree = generateRedBlackTree(arrayNumbers, i);
            System.out.println("Time to construct RB Tree: " + timesRB[i]+ " nanoseconds");
            System.out.println("RedBlack Height: " + heightInRBTree(RBTree,i));

            //Table
            int[] random10 = generateRandomIntArray(10, arrayNumbers);

            if(i == 0) System.out.println("Number \t BST \t AVL \t RBT");

            for (int j = 0; j < 10; j++) {
                searchElementInAVLTree(random10[j],AVLTree, j);
                searchElementInBSTree(random10[j],BSTree, j);
                searchElementInRBTree(random10[j],RBTree, j);
                if(i == 0) System.out.println(random10[j] +"\t"+ triesBS[j]+"\t"+ triesAVL[j]+"\t"+ triesRB[j]);
            }
            double [] averageTries = averageTries();
            averageTriesBS[i] = averageTries[0];
            averageTriesAVL[i] = averageTries[1];
            averageTriesRB[i] = averageTries[2];
            if(i == 0) System.out.println("Average \t "+ averageTries[0] +" \t "+ averageTries[1] +" \t "+ averageTries[2]);
            //Table of average 10 times
            if (i == n-1 && i != 0){
                double [] averageHeight = averageHeight(n);
                double [] averageTriesAv = averageTriesAv(n);
                double [] averageTime = averageTime(n);
                System.out.println("\n"+ "Average \t BST \t AVL \t RBT");
                System.out.println("Height \t"+ averageHeight[0] +"\t"+ averageHeight[1]+"\t"+ averageHeight[2]);
                System.out.println("Tries \t"+ averageTriesAv[0] +"\t"+ averageTriesAv[1]+"\t"+ averageTriesAv[2]);
                System.out.println("Time \t"+ averageTime[0] +"\t"+ averageTime[1]+"\t"+ averageTime[2]);
            }
        }
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

    public static int[] generateRandomIntArray (int n, int[] array){
        int[] arrayNumbers = new int[n];
        for (int i = 0; i < 10; i++) {
            arrayNumbers[i] = array[(int)(Math.random()* ((array.length-1) + 1))];
        }
        return arrayNumbers;
    }

    private static BinarySearchTree<Integer> generateBSTree(int[] intArray, int i) {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            bsTree.insert(value);
        }
        timesBS[i] = System.nanoTime() - startTime;
        return bsTree;
    }

    public static AVLTree<Integer> generateAVLTree (int[] intArray, int i){
        AVLTree<Integer> AVLTree = new AVLTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            AVLTree.insert(value);
        }
        timesAVL[i] = System.nanoTime() - startTime;
        return AVLTree;
    }

    public static RBTree<Integer> generateRedBlackTree (int[] intArray, int i){
        RBTree<Integer> RBTree = new RBTree<>();
        long startTime = System.nanoTime();
        for (int value : intArray) {
            RBTree.insert(value);
        }
        timesRB[i] = System.nanoTime() - startTime;
        return RBTree;
    }

    public static void searchElementInBSTree (int n, BinarySearchTree<Integer> bsTree, int i){
        triesBS[i] = bsTree.searchWithCounter(n);//result is added directly to array, no need to return anything
    }
    public static void searchElementInAVLTree (int n, AVLTree<Integer> avlTree, int i){
        triesAVL[i] = avlTree.searchWithCounter(n);//result is added directly to array, no need to return anything
    }
    public static void searchElementInRBTree (int n, RBTree<Integer> rbTree, int i){
        triesRB[i] = rbTree.searchWithCounter(n);//result is added directly to array, no need to return anything
    }

    public static int heightInBSTree (BinarySearchTree<Integer> bsTree, int i){
        heightsBS[i] = bsTree.height();
        return bsTree.height();
    }
    public static int heightInAVLTree (AVLTree<Integer> avlTree, int i){
        heightsAVL[i] = avlTree.getHeight();
        return avlTree.getHeight();
    }
    public static int heightInRBTree (RBTree<Integer> rbTree, int i){
        heightsRB[i] = rbTree.height();
        return rbTree.height();
    }

    public static double[] averageTries(){
        return averageForSearchElements(sumTries());
    }

    public static int[] sumTries (){
        return sumOfElements(triesBS, triesAVL, triesRB);
    }

    public static int[] sumTriesAverage (){
        return sumOfElements(averageTriesBS,averageTriesAVL,averageTriesRB);
    }

    public static double[] averageTriesAv(int n){
        return average(sumTriesAverage(), n);
    }

    public static int[] sumTimes (){
        return sumOfElements(timesBS,timesAVL,timesRB);
    }

    public static double[] averageTime(int n){
        return average(sumTimes(), n);
    }

    public static int[] sumHeights (){
        return sumOfElements(heightsBS,heightsAVL,heightsRB);
    }

    public static double[] averageHeight(int n){
        return average(sumHeights(), n);
    }

    public static double[] average(int[] array, int n){
        double[] averageTries = new double[3];
        averageTries[0]= (double)array[0]/n;
        averageTries[1]= (double)array[1]/n;
        averageTries[2]= (double)array[2]/n;
        return averageTries;
    }

    public static double[] averageForSearchElements(int[] array){
        double[] averageTries = new double[3];
        averageTries[0]= (double)array[0]/10;
        averageTries[1]= (double)array[1]/10;
        averageTries[2]= (double)array[2]/10;
        return averageTries;
    }

    public static int[] sumOfElements(long[] bsArray, long[] avlArray, long[] rbArray){
        int[] sumAverageTries = new int[3];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += bsArray[i];
        }
        sumAverageTries[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += avlArray[i];
        }
        sumAverageTries[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += rbArray[i];
        }
        sumAverageTries[2] = result;
        return sumAverageTries;
    }
    public static int[] sumOfElements(double[] bsArray, double[] avlArray, double[] rbArray){
        int[] sumAverageTries = new int[3];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += bsArray[i];
        }
        sumAverageTries[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += avlArray[i];
        }
        sumAverageTries[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += rbArray[i];
        }
        sumAverageTries[2] = result;
        return sumAverageTries;
    }
}

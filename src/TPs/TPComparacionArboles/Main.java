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
        timesAVL = new long[11];
        timesBS = new long[11];
        timesRB = new long[11];
        triesAVL = new long[11];
        triesBS = new long[11];
        triesRB = new long[11];
        heightsAVL = new long[11];
        heightsBS = new long[11];
        heightsRB = new long[11];
        averageTriesAVL = new double[11];
        averageTriesBS = new double[11];
        averageTriesRB = new double[11];
        hacerEjercicio(11);

    }

    public static void hacerEjercicio(int n){

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

            //Parte de la tabla
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
            if (i == n-1){
                double [] averageHeight = averageHeight();
                double [] averageTriesAv = averageTriesAv();
                double [] averageTime = averageTime();
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
            arrayNumbers[i] = array[(int)(Math.random()* ((array.length) + 1))];
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

    public static int searchElementInBSTree (int n, BinarySearchTree<Integer> bsTree, int i){
        triesBS[i] = bsTree.searchWithCounter(n);
        return bsTree.searchWithCounter(n);
    }
    public static int searchElementInAVLTree (int n, AVLTree<Integer> avlTree, int i){
        triesAVL[i] = avlTree.searchWithCounter(n);
        return avlTree.searchWithCounter(n);
    }
    public static int searchElementInRBTree (int n, RBTree<Integer> rbTree, int i){
        triesRB[i] = rbTree.searchWithCounter(n);
        return rbTree.searchWithCounter(n);
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

    public static int[] sumTries (){
        int[] sumTries = new int[3];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += triesBS[i];
        }
        sumTries[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += triesAVL[i];
        }
        sumTries[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += triesRB[i];
        }
        sumTries[2] = result;
        return sumTries;
    }

    public static double[] averageTries(){
        double[] averageTries = new double[3];
        int [] sumTries = sumTries();
        averageTries[0]= (double)sumTries[0]/10;
        averageTries[1]= (double)sumTries[1]/10;
        averageTries[2]= (double)sumTries[2]/10;
        return averageTries;
    }

    public static int[] sumTriesAverage (){
        int[] sumAverageTries = new int[3];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += averageTriesBS[i];
        }
        sumAverageTries[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += averageTriesAVL[i];
        }
        sumAverageTries[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += averageTriesRB[i];
        }
        sumAverageTries[2] = result;
        return sumAverageTries;
    }

    public static double[] averageTriesAv(){
        double[] averageTriesAv = new double[3];
        int [] sumTriesAv = sumTriesAverage();
        averageTriesAv[0]= (double)sumTriesAv[0]/11;
        averageTriesAv[1]= (double)sumTriesAv[1]/11;
        averageTriesAv[2]= (double)sumTriesAv[2]/11;
        return averageTriesAv;
    }

    public static long[] sumTimes (){
        long[] sumTimes = new long[3];
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += timesBS[i];
        }
        sumTimes[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += timesAVL[i];
        }
        sumTimes[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += timesRB[i];
        }
        sumTimes[2] = result;
        return sumTimes;
    }

    public static double[] averageTime(){
        double[] averageTime = new double[3];
        long [] sumTimes = sumTimes();
        averageTime[0]= (double)sumTimes[0]/11;
        averageTime[1]= (double)sumTimes[1]/11;
        averageTime[2]= (double)sumTimes[2]/11;
        return averageTime;
    }

    public static int[] sumHeights (){
        int[] sumHeights = new int[3];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += heightsBS[i];
        }
        sumHeights[0] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += heightsAVL[i];
        }
        sumHeights[1] = result;
        result = 0;
        for (int i = 0; i < 10; i++) {
            result += heightsRB[i];
        }
        sumHeights[2] = result;
        return sumHeights;
    }

    public static double[] averageHeight(){
        double[] averageTime = new double[3];
        int [] sumHeights = sumHeights();
        averageTime[0]= (double)sumHeights[0]/11;
        averageTime[1]= (double)sumHeights[1]/11;
        averageTime[2]= (double)sumHeights[2]/11;
        return averageTime;
    }


}

package TPs.TP6;

import java.util.ArrayList;
import java.util.Scanner;

public class GenomeAnalyzer {
    static AVLTree<Organism> organismAVLTree;

    public static void main(String[] args) {
        organismAVLTree = new AVLTree<>();
        menuScreen();
    }

    public AVLTree<Organism> convertListIntoTree (ArrayList<Organism> organismList){
        for (Organism organism: organismList) {
            organismAVLTree.insert(organismAVLTree.root, organism);
        }
        return organismAVLTree;
    }

    public static void menuScreen (){
        System.out.println("Menu Screen" + "\n"+ "Choose an option:"+ "\n"+
                "0. Exit"+ "\n"+
                "1. Add an Organism"+ "\n"+
                "2. Remove an Organism" + "\n"+
                "3. Modify an Organism"+ "\n"+
                "4. Show Tree");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int option = scanner.nextInt();
            switch (option){
                case 0:
                    System.exit(0);
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter Code");
                    String code = scanner.nextLine();
                    System.out.println("Enter Type");
                    String type = scanner.nextLine();
                    System.out.println("Enter Description");
                    String description = scanner.nextLine();
                    System.out.println("Enter Genome Size");
                    int size = scanner.nextInt();
                    Organism organism = new Organism(code, type, description, size);
                    organismAVLTree.root = organismAVLTree.insert(organismAVLTree.root, organism);
                    System.out.println(code+ " Added to tree");
                    break;
                case 2:
                    //precondition: The organism with that code should already be in the Tree
                    scanner.nextLine();
                    System.out.println("Enter Code");
                    String code2 = scanner.nextLine();
                    Organism temp = new Organism(code2);
                    organismAVLTree.deleteNode(organismAVLTree.root, temp);
                    System.out.println(code2+ " removed from tree");
                    break;
                case 3:
                    //precondition: The organism with that code should already be in the Tree
                    scanner.nextLine();
                    System.out.println("Enter Code");
                    String code3 = scanner.nextLine();
                    System.out.println("Enter New Type");
                    String type2 = scanner.nextLine();
                    System.out.println("Enter New Description");
                    String description2 = scanner.nextLine();
                    System.out.println("Enter New Genome Size");
                    int size2 = scanner.nextInt();
                    Organism organism2 = new Organism(code3, type2, description2, size2);
                    organismAVLTree.deleteNode(organismAVLTree.root, organism2);
                    organismAVLTree.insert(organismAVLTree.root, organism2);
                    break;
                case 4:
                    showInOrden(organismAVLTree);
                    break;
            }
        }
    }

    static void showInOrden (AVLTree<Organism> AVLTree){
        if (AVLTree.isEmpty()) System.out.println("");
        else if(AVLTree.getLeft().isEmpty() && AVLTree.getRight().isEmpty()){
            System.out.println(AVLTree.root.key.getCode());
        }
        else{
            showInOrden(AVLTree.getLeft());
            System.out.println(AVLTree.root.key.getCode());
            showInOrden(AVLTree.getRight());
        }
    }
}

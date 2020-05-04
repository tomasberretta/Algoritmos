package TPs.TP6;

import java.util.ArrayList;

public class GenomeAnalyzer {
    static AVLTree<Organism> organismAVLTree;
    static ArrayList<Organism> organisms;

    public static void main(String[] args) {
        organisms = new ArrayList<>();
        organismAVLTree = new AVLTree<>();
        organisms.add(new Organism("Covid", "Virus", "Very bad", 12));
        organismAVLTree = convertListIntoTree(organisms);
        menuScreen();
    }

    public static AVLTree<Organism> convertListIntoTree (ArrayList<Organism> organismList){
        for (Organism organism: organismList) {
            organismAVLTree.insert(organism);
        }
        return organismAVLTree;
    }

    public static void menuScreen (){
        while (true){
        System.out.println("\n"+"Menu Screen" + "\n"+ "Choose an option:"+ "\n"+
                "0. Exit"+ "\n"+
                "1. Add an Organism"+ "\n"+
                "2. Remove an Organism" + "\n"+
                "3. Modify an Organism"+ "\n"+
                "4. Search an Organism"+ "\n"+
                "5. Show Tree");
            int option = Scanner.getInt("");
            switch (option){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter Code");
                    String code = Scanner.getString("");
                    System.out.println("Enter Type");
                    String type = Scanner.getString("");
                    System.out.println("Enter Description");
                    String description = Scanner.getString("");
                    System.out.println("Enter Genome Size");
                    int size = Scanner.getInt("");
                    Organism organism = new Organism(code, type, description, size);
                    organismAVLTree.insert(organism);
                    System.out.println(code+ " Added to tree");
                    break;
                case 2:
                    System.out.println("Enter Code");
                    String code2 = Scanner.getString("");
                    Organism temp = new Organism(code2);
                    if (organismAVLTree.isInTree(temp)){
                        organismAVLTree.delete(temp);
                        System.out.println(code2+ " removed from tree");
                    }else{
                        System.out.println(code2 + " was not found in the tree");
                    }
                    break;
                case 3:
                    System.out.println("Enter Code");
                    String code3 = Scanner.getString("");
                    System.out.println("Enter New Type");
                    String type2 = Scanner.getString("");
                    System.out.println("Enter New Description");
                    String description2 = Scanner.getString("");
                    System.out.println("Enter New Genome Size");
                    int size2 = Scanner.getInt("");
                    Organism organism2 = new Organism(code3, type2, description2, size2);
                    if (organismAVLTree.isInTree(organism2)){
                        organismAVLTree.delete(organism2);
                        organismAVLTree.insert(organism2);
                        System.out.println(code3+ " modified from tree");
                    }else{
                        System.out.println(code3 + " was not found in the tree");
                    }
                    break;
                case 4:
                    System.out.println("Enter Code");
                    String code4 = Scanner.getString("");
                    Organism temp2 = new Organism(code4);
                    if (organismAVLTree.isInTree(temp2)){
                        Organism toShow = organismAVLTree.search(temp2);
                        System.out.println(toShow.getCode()+ "\n"+
                                toShow.getType()+ "\n"+
                                toShow.getDescription()+ "\n"+
                                toShow.getSize());
                    }else{
                        System.out.println(code4 + " was not found in the tree");
                    }
                    break;
                case 5:
                    System.out.println("Tree: ");
                    showInOrden(organismAVLTree);
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    static void showInOrden (AVLTree<Organism> AVLTree){
        if (AVLTree.isEmpty()) System.out.println("");
        else if(AVLTree.getLeft().isEmpty() && AVLTree.getRight().isEmpty()){
            System.out.println(AVLTree.root.data.getCode());
        }
        else{
            showInOrden(AVLTree.getLeft());
            System.out.println(AVLTree.root.data.getCode());
            showInOrden(AVLTree.getRight());
        }
    }
}

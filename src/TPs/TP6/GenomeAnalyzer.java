package TPs.TP6;

import java.util.ArrayList;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class GenomeAnalyzer {
    static BinarySearchTree<Organism> organismBinarySearchTree;
    static ArrayList<Organism> organisms;

    public static void main(String[] args) {
        organisms = new ArrayList<>();
        organismBinarySearchTree = new BinarySearchTree<>();
        addOrganismsToList();
        organismBinarySearchTree = convertListIntoTree(organisms);
        menuScreen();
    }

    public static BinarySearchTree<Organism> convertListIntoTree (ArrayList<Organism> organismList){
        for (Organism organism: organismList) {
            organismBinarySearchTree.insert(organism);
        }
        return organismBinarySearchTree;
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
                    organismBinarySearchTree.insert(organism);
                    System.out.println(code+ " Added to tree");
                    break;
                case 2:
                    System.out.println("Enter Code");
                    String code2 = Scanner.getString("");
                    Organism temp = new Organism(code2);
                    if (organismBinarySearchTree.isInTree(temp)){
                        organismBinarySearchTree.delete(temp);
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
                    if (organismBinarySearchTree.isInTree(organism2)){
                        organismBinarySearchTree.delete(organism2);
                        organismBinarySearchTree.insert(organism2);
                        System.out.println(code3+ " modified from tree");
                    }else{
                        System.out.println(code3 + " was not found in the tree");
                    }
                    break;
                case 4:
                    System.out.println("Enter Code");
                    String code4 = Scanner.getString("");
                    Organism temp2 = new Organism(code4);
                    if (organismBinarySearchTree.isInTree(temp2)){
                        Organism toShow = organismBinarySearchTree.search(temp2);
                        System.out.println("Code: "+ toShow.getCode()+ "\n"+
                                "Type: "+toShow.getType()+ "\n"+
                                "Description: "+toShow.getDescription()+ "\n"+
                                "Size: "+toShow.getSize());
                    }else{
                        System.out.println(code4 + " was not found in the tree");
                    }
                    break;
                case 5:
                    System.out.println("Tree: ");
                    showInOrden(organismBinarySearchTree);
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    static void showInOrden (BinarySearchTree<Organism> binarySearchTree){
        if (binarySearchTree.isEmpty()) System.out.println("");
        else if(binarySearchTree.getLeft().isEmpty() && binarySearchTree.getRight().isEmpty()){
            System.out.println(binarySearchTree.getRoot().getCode());
        }
        else{
            showInOrden(binarySearchTree.getLeft());
            System.out.println(binarySearchTree.getRoot().getCode());
            showInOrden(binarySearchTree.getRight());
        }
    }

    private static void addOrganismsToList() {
        organisms.add(new Organism("SV40", "Virus", "A polyomavirus that is found in both monkeys and humans.", 6));
        organisms.add(new Organism("HIV", "Virus", "Species of Lentivirus that infect humans and over time cause acquired immunodeficiency syndrome.", 10));
        organisms.add(new Organism("Phage", "Virus", "A single-stranded DNA virus that infects Escherichia coli, and the first DNA-based genome to be sequenced.", 50));
        organisms.add(new Organism("Inflz", "Bacterium", "A Gram-negative, coccobacillary, facultatively anaerobic pathogenic bacterium of the family Pasteurellaceae.", 2));
        organisms.add(new Organism("Coli", "Bacterium", "A Gram-negative, facultative anaerobic, rod-shaped, coliform bacterium of the genus Escherichia that is commonly found in the lower intestine of warm-blooded organisms.", 5));
        organisms.add(new Organism("Genli", "Plant", "A carnivorous species in the genus Genlisea that is endemic to Brazil and found only in campos rupestres vegetation.", 61));
        organisms.add(new Organism("Sacch", "Fungus", "A species of yeast that has been instrumental in winemaking, baking, and brewing since ancient times.", 12));
        organisms.add(new Organism("Asper", "Fungus", "One of many species of filamentous fungi in the phylum Ascomycota.", 30));
        organisms.add(new Organism("Pscus", "Mammal", "An endangered great ape and one of the two species making up the genus Pan.", 3));
        organisms.add(new Organism("Muscu", "Mammal", "A small mammal of the order Rodentia, characteristically having a pointed snout, large rounded ears, and a long and hairy tail.", 3));
        organisms.add(new Organism("Hsap", "Mammal", "The only extant human species.", 3));
    }
}

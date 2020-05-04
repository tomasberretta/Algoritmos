package TPs.TP6;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Organism implements Comparable<Organism> {
    String code;
    String type;
    String description;
    int size;

    public Organism(String code, String type, String description, int size) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.size = size;
    }

    public Organism(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Organism o) {
        return code.compareTo(o.getCode());
    }

    public int getSize() {
        return size;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}

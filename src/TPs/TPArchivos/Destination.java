package TPs.TPArchivos;

import java.io.Serializable;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/


public class Destination implements Serializable {
    String destinationCode;
    String description;

    public Destination(String destinationCode, String description) {
        this.destinationCode = destinationCode;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getDestinationCode() {
        return destinationCode;
    }
}

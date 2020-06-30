package TPs.TPArchivos;

import java.io.*;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/


public class DestinationFile {
    private File f;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;


    public DestinationFile (String name) throws IOException {
        f = new File(name);
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
    }

    public void write (Destination destination) throws IOException {
        oos.writeObject(destination);
    }

    public Destination read() throws IOException, ClassNotFoundException {
        return  (Destination) ois.readObject();
    }

    public void close() throws IOException{
        fos.close();
        oos.close();
        fis.close();
        ois.close();
    }
}
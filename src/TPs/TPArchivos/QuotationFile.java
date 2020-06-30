package TPs.TPArchivos;

import java.io.*;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class QuotationFile {
    private File f;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;

    public QuotationFile (String name) throws IOException {
        f = new File(name);
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
    }

    public void write (Quotation quotation) throws IOException {
        oos.writeObject(quotation);
    }

    public Quotation read() throws IOException, ClassNotFoundException {
        return (Quotation) ois.readObject();
    }

    public void close() throws IOException{
        oos.close();
        ois.close();
    }

    public Quotation[] getQuotations() {
        Quotation[] quotations = new Quotation[12];
        for (int i = 0; i < quotations.length; i++) {
            try {
                quotations[i] = read();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return quotations;
    }
}

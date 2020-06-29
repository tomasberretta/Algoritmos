package TPs.TPArchivos;

import java.io.*;

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
        fos.close();
        oos.close();
        fis.close();
        ois.close();
    }
}

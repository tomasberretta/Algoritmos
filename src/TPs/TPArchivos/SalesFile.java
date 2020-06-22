package TPs.TPArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SalesFile {
    private File f;
    private RandomAccessFile raf;
    private int sizeReg = 8+4+4+8+4+4+4;

    public SalesFile (String name) throws FileNotFoundException {
        f = new File(name);
        raf = new RandomAccessFile(f, "rw");
    }

    public void write (Sale s) throws IOException {
        raf.writeUTF(s.getDestinationCode());
        raf.writeInt(s.getCode());
        raf.writeInt(s.getAmount());
        raf.writeDouble(s.getPriceInDolars());
        raf.writeInt(s.getDay());
        raf.writeInt(s.getMonth());
        raf.writeInt(s.getYear());
    }

    public Sale searchByDestination (String destinationCode) throws Exception{
        long quant = sizeReg;
        start();
        Sale s;
        for (int i =0 ; i < quant;i++){
            s = read();
            if(s.getDestinationCode().equals(destinationCode))
                return s;
        }
        throw new Exception("Código erróneo");
    }

    public Sale searchByMonth (int month) throws Exception{
        long quant = sizeReg;
        start();
        Sale s;
        for (int i =0 ; i < quant;i++){
            s = read();
            if(s.getMonth() == month)
                return s;
        }
        throw new Exception("Código erróneo");
    }

    public Sale read() throws IOException{
        return new Sale(raf.readUTF(), raf.readInt(), raf.readInt(),raf.readDouble(),
                raf.readInt(),raf.readInt(),raf.readInt());
    }

    public long quantReg() throws IOException {
        return raf.length()/sizeReg;
    }

    public void start () throws IOException {
        raf.seek(0);
    }

    public void end () throws IOException {
        raf.seek(raf.length());
    }

    public void close() throws IOException{
        raf.close();
    }
}

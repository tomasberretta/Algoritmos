package TPs.TP1.Ejercicio_1;

import java.io.IOException;

public class Sequencial {

    public <T> int seqSearch ( Comparable <T> a[], Comparable <T> k) throws IOException {
        for ( int i = 0; i < a.length; i++ )
            if (k.compareTo((T) a[i]) == 0){
                return i;
            }
  throw new IOException("The element you are looking for does not appear in the collection");
    }
}

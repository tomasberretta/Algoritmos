package TPs.TP1.Ejercicio_1;

import java.io.IOException;
import java.util.ArrayList;

public class Binary{

    public <T> int BinarySearch(Comparable <T> a[], Comparable <T> k) throws IOException {
        int min = 0;
        int max = a.length-1;
        int middle = (min+max)/2;
            while(min <= max) {
                if (k.compareTo((T) a[middle])== 0)

                    return middle;

                else if (k.compareTo((T) a[middle]) < 0 )
                    max = middle-1;

                else
                middle = (min+max)/2;
                min = middle +1;
        }
            throw new IOException("The elements you are looking for does not appear in the collection");

    }

}
package TPs.TP1.Ejercicio_3;

public class Ej3 {

    public <T> Comparable<T>[] merge(Comparable<T>[] a, Comparable<T>[] b){
        int j = 0;
        int k = 0;
        Comparable<T>[] c = new Comparable[a.length+b.length];
        for (int i = 0; i < c.length; i++) {
            if(k < a.length && j < b.length){
                if(a[k].compareTo((T)b[j]) <= 0 ){
                    c[i] = a[k];
                    k++;
                }else {
                    c[i] = b[j];
                    j++;
                }
            }else if (j < b.length){
                c[i] = b[j];
                j++;
            }else if (k < a.length){
                c[i] = a[k];
                k++;
            }
        }
        return c;
    }
}

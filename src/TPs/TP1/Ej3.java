package TPs.TP1;

public class Ej3 {


    public static Comparable[] merge (Comparable[] a, Comparable[] b){
        int j = 0;
        int k = 0;
        Comparable[] c = new Comparable[a.length+b.length];
        for (int i = 0; i < c.length; i++) {
            if(k < a.length && j < b.length){
                if(a[k].compareTo(b[j]) <= 0 ){
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

    public static Comparable[] merge2 ( Comparable[] a, Comparable[] b ){
        int j = 0;
        int k = 0;
        Comparable[] c = new Comparable[a.length+b.length];
        for (int i = 0; i < c.length; i++) {
            if(a[k].compareTo(b[j]) <= 0) {
                c[i] = a[k];
                if(k < a.length-1) {
                    k++;
                }
            }
            if(a[k].compareTo(b[j]) > 0){
                c[i] = b[j];
                if(j < b.length-1) {
                    j++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Auto auto1 = new Auto(1);
        Auto auto2 = new Auto(2);
        Auto auto3 = new Auto(4);
        Auto auto4 = new Auto(6);
        Auto auto5 = new Auto(8);
        Auto auto6 = new Auto(12);
        Auto auto7 = new Auto(3);
        Auto auto8 = new Auto(7);

        Auto[] autos1 = new Auto[]{auto1, auto2, auto3,auto4, auto5,auto6};
        Auto[] autos2 = new Auto[]{ auto7, auto8};

        Comparable[] autos3 =  merge(autos1, autos2);

        print(autos3);

    }

    public static void print (Comparable[] conjunto){
        for (int i = 0; i < conjunto.length; i++) {
            if(conjunto[i] instanceof Auto){
                System.out.println(((Auto)conjunto[i]).getPatente());
            }
        }
    }


}

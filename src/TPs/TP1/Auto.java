package TPs.TP1;

public class Auto implements Comparable<Auto> {
    int patente;

    public Auto(int patente) {
        this.patente = patente;
    }

    @Override
    public int compareTo(Auto o) {
        if (patente < o.patente){
            return -1;
        } else if (patente == o.patente){
            return 0;
        }else return 1;
    }

    public int getPatente() {
        return patente;
    }
}

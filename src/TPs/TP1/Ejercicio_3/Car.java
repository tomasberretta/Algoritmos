package TPs.TP1.Ejercicio_3;

public class Car implements Comparable<Car> {
    int licensePlate;

    public Car(int licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public int compareTo(Car o) {
        if (licensePlate < o.licensePlate){
            return -1;
        } else if (licensePlate == o.licensePlate){
            return 0;
        }else return 1;
    }

    public int getLicensePlate() {
        return licensePlate;
    }
}

package TPs.TP1.Ejercicio_3;

import org.junit.Assert;
import org.junit.Test;

public class Ej3Test {

    @Test
    public void mergeTest() {
        //setup
        Ej3 ej3 = new Ej3();

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(4);
        Car car4 = new Car(6);
        Car car5 = new Car(8);
        Car car6 = new Car(12);
        Car car7 = new Car(3);
        Car car8 = new Car(7);

        Car[] cars1 = new Car[]{car1, car2, car3, car4, car5, car6};
        Car[] cars2 = new Car[]{car7, car8};

        //action
        Comparable<Car>[] cars3 =  ej3.merge(cars1, cars2);

        //assertion
        Assert.assertEquals(1,((Car)cars3[0]).getLicensePlate());
        Assert.assertEquals(2,((Car)cars3[1]).getLicensePlate());
        Assert.assertEquals(3,((Car)cars3[2]).getLicensePlate());
        Assert.assertEquals(4,((Car)cars3[3]).getLicensePlate());
        Assert.assertEquals(6,((Car)cars3[4]).getLicensePlate());
        Assert.assertEquals(7,((Car)cars3[5]).getLicensePlate());
        Assert.assertEquals(8,((Car)cars3[6]).getLicensePlate());
        Assert.assertEquals(12,((Car)cars3[7]).getLicensePlate());

    }
}
package TPs.TP1.Ejercicio_1;

import TPs.TP1.Ejercicio_3.Car;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class SequencialTest {

    @Test
    public void seqSearchTest() {
        //setup
        Sequencial sequencial = new Sequencial();

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(4);
        Car car4 = new Car(6);
        Car car5 = new Car(8);
        Car car6 = new Car(10);
        Car car7 = new Car(12);
        Car car8 = new Car(15);
        int result1 =0;
        int result2 =0;
        int result3 =0;
        int result4  =0;
        int result5 =0;
        int result6 =0;
        int result7 =0;
        int result8 =0;


        Car[] cars = new Car[]{car1, car2, car3, car4, car5, car6, car7, car8};

        //action
        try {
            result1= sequencial.seqSearch(cars, car1);
            result2= sequencial.seqSearch(cars, car2);
            result3= sequencial.seqSearch(cars, car3);
            result4= sequencial.seqSearch(cars, car4);
            result5= sequencial.seqSearch(cars, car5);
            result6= sequencial.seqSearch(cars, car6);
            result7= sequencial.seqSearch(cars, car7);
            result8= sequencial.seqSearch(cars, car8);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //assertion
        Assert.assertEquals(0,result1);
        Assert.assertEquals(1,result2);
        Assert.assertEquals(2,result3);
        Assert.assertEquals(3,result4);
        Assert.assertEquals(4,result5);
        Assert.assertEquals(5,result6);
        Assert.assertEquals(6,result7);
        Assert.assertEquals(7,result8);
    }
}
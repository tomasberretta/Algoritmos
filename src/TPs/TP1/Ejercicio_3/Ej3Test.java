package TPs.TP1.Ejercicio_3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ej3Test {

    @Test
    public void mergeTest() {
        //setup
        Ej3 ej3 = new Ej3();

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

        //action
        Comparable<Auto>[] autos3 =  ej3.merge(autos1, autos2);

        //assertion
        Assert.assertEquals(1,((Auto)autos3[0]).getPatente());
        Assert.assertEquals(2,((Auto)autos3[1]).getPatente());
        Assert.assertEquals(3,((Auto)autos3[2]).getPatente());
        Assert.assertEquals(4,((Auto)autos3[3]).getPatente());
        Assert.assertEquals(6,((Auto)autos3[4]).getPatente());
        Assert.assertEquals(7,((Auto)autos3[5]).getPatente());
        Assert.assertEquals(8,((Auto)autos3[6]).getPatente());
        Assert.assertEquals(12,((Auto)autos3[7]).getPatente());

    }
}
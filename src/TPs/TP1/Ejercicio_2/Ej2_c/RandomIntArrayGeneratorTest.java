package TPs.TP1.Ejercicio_2.Ej2_c;

import org.junit.Assert;
import org.junit.Test;

public class RandomIntArrayGeneratorTest {
    @Test
    public void randomIntArraysWith5ElementsShouldBeCreated(){
        RandomIntArrayGenerator arrayGenerator = new RandomIntArrayGenerator();
        int[] arrayShort = arrayGenerator.generateRandomArray(5);

        Assert.assertEquals(5, arrayShort.length);
    }
    @Test
    public void randomIntArraysWith10000ElementsShouldBeCreated(){
        RandomIntArrayGenerator arrayGenerator = new RandomIntArrayGenerator();
        int[] arrayLong = arrayGenerator.generateRandomArray(10000);

        Assert.assertEquals(10000, arrayLong.length);
    }

}
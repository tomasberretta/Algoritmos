package TPs.TP1.Ejercicio_2;

import java.util.Random;

public class RandomIntArrayGenerator {
    public int[] generateRandomArray(int n){
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        return array;
    }
}
/*T(n)=3n+4
If n is a big number the algorithm takes longer to run.
With n = 5 it takes 19. with n = 5000 it takes 15004 and with n = 10000 it takes up to 30004
 */

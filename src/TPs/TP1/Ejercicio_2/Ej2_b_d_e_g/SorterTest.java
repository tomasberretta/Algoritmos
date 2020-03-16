package TPs.TP1.Ejercicio_2.Ej2_b_d_e_g;

import TPs.TP1.Ejercicio_3.Car;
import org.junit.Assert;
import org.junit.Test;

public class SorterTest {
    Integer[] intArray = {2,5,1,8,4};
    String[] stringArray = {"y", "a", "c", "a", "h", "b"};
    Sorter sorter = new Sorter();

    @Test
    public void bubbleSortShouldOrderElementsOfAnyType(){
        sorter.bubbleSort(intArray);
        sorter.bubbleSort(stringArray);

        Assert.assertEquals(stringArray, new String[]{"a", "a", "b", "c", "h", "y"});
        Assert.assertEquals(intArray, new Integer[]{1,2,4,5,8});
    }

    @Test
    public void selectionSortShouldOrderElementsOfAnyType(){
        sorter.selectionSort(intArray);
        sorter.selectionSort(stringArray);

        Assert.assertEquals(stringArray, new String[]{"a", "a", "b", "c", "h", "y"});
        Assert.assertEquals(intArray, new Integer[]{1,2,4,5,8});
    }

    @Test
    public void recurSelectionSortShouldOrderElementsOfAnyType(){
        sorter.recurSelectionSort(intArray, intArray.length, 0);
        sorter.recurSelectionSort(stringArray, stringArray.length, 0);

        Assert.assertEquals(stringArray, new String[]{"a", "a", "b", "c", "h", "y"});
        Assert.assertEquals(intArray, new Integer[]{1,2,4,5,8});
    }

    @Test
    public void insertionSortShouldOrderElementsOfAnyType(){
        sorter.insertionSort(intArray);
        sorter.insertionSort(stringArray);

        Assert.assertEquals(stringArray, new String[]{"a", "a", "b", "c", "h", "y"});
        Assert.assertEquals(intArray, new Integer[]{1,2,4,5,8});
    }

    @Test
    public void carComparasionTest(){
        Car car = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(4);
        Car car5 = new Car(5);

        Car[] cars = {car2, car4, car, car5, car3};

        sorter.bubbleSort(cars);
        Assert.assertEquals(new Car[]{car, car2, car3, car4, car5}, cars);
    }
}
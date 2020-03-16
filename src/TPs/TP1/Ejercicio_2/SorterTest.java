package TPs.TP1.Ejercicio_2;

import TPs.TP1.Ejercicio_3.Auto;
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
    public void autoComparasionTest(){
        Auto car = new Auto(1);
        Auto car2 = new Auto(2);
        Auto car3 = new Auto(3);
        Auto car4 = new Auto(4);
        Auto car5 = new Auto(5);

        Auto[] autos = {car2, car4, car, car5, car3};

        sorter.bubbleSort(autos);
        Assert.assertEquals(new Auto[]{car, car2, car3, car4, car5}, autos);
    }
}
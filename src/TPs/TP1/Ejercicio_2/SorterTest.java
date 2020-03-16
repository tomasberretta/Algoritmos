package TPs.TP1.Ejercicio_2;

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
    public void insertionSortShouldOrderElementsOfAnyType(){
        sorter.insertionSort(intArray);
        sorter.insertionSort(stringArray);

        Assert.assertEquals(stringArray, new String[]{"a", "a", "b", "c", "h", "y"});
        Assert.assertEquals(intArray, new Integer[]{1,2,4,5,8});
    }

}
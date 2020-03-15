package TPs.TP1.Ejercicio_2;

public class Sorter<T extends Comparable<T>> {

    public void bubbleSort(T[] values){
        boolean isSorted; //boolean is used so that no unnecessary iterations occur.

        for (int i = 1; i < values.length; i++) {
            isSorted = true;
            for (int j = 0; j < values.length - i; j++) {
                if(values[j].compareTo(values[j+1]) > 0){
                     isSorted = false;
                     swap(values, j, j+1);
                }
            }
            if(isSorted) break;
        }
    }

    public void selectionSort(T[] values){
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < values.length; j++) {
                if(values[j].compareTo(values[minIndex]) < 0){
                    minIndex = j;
                }
                swap(values, minIndex, i);
            }
        }
    }

    public void insertionSort(T[] values){
        for (int i = 1; i < values.length; i++) {
            T key = values[i];
            int j = i - 1;

            /* Move elements of values[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while(j >= 0 && values[j].compareTo(key) > 0){
                values[j+1] = values[j];
                j = j - 1;
            }
            values[j+1] = key;
        }
    }

    private void swap(T[] values, int first, int second) {
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }
}

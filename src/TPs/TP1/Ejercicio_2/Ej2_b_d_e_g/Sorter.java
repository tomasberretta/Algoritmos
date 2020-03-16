package TPs.TP1.Ejercicio_2.Ej2_b_d_e_g;

public class Sorter<T extends Comparable<T>> {

    public void bubbleSort(int[] values){
        boolean isSorted; //boolean is used so that no unnecessary iterations occur.

        for (int i = 1; i < values.length; i++) {
            isSorted = true;
            for (int j = 0; j < values.length - i; j++) {
                if(values[j] > values[j+1]){
                     isSorted = false;
                     swap(values, j, j+1);
                }
            }
            if(isSorted) break;
        }
    }

    public void bubbleSort(String[] values){
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

    public void selectionSort(int[] values){
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < values.length; j++) {
                if(values[j] < values[minIndex]){
                    minIndex = j;
                }
            }
            swap(values, minIndex, i);
        }
    }

    public void selectionSort(String[] values){
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < values.length; j++) {
                if(values[j].compareTo(values[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(values, minIndex, i);
        }
    }

    public void selectionSort(T[] values){
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < values.length; j++) {
                if(values[j].compareTo(values[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(values, minIndex, i);
        }
    }

    // Recursive selection sort.
    public void recurSelectionSort(T[] values, int length, int index)
    {

        // Return when index and size are same
        if (index == length)
            return;

        // Calling minimum index function for minimum index
        int k = minIndex(values, index, length-1);

        // Swapping when index and minimum index are not same
        if (k != index){
            swap(values, k ,index);
        }
        // Recursively calling selection sort function
        recurSelectionSort(values, length, index + 1);
    }

    public void insertionSort(int[] values){
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;

            /* Move elements of values[0..i-1], that are
               greater than key, to one position ahead
               of their current position */

            while(j >= 0 && values[j] > key){
                values[j+1] = values[j];
                j = j - 1;
            }
            values[j+1] = key;
        }
    }

    public void insertionSort(String[] values){
        for (int i = 1; i < values.length; i++) {
            String key = values[i];
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

    //Auxiliary methods

    public int minIndex(T[] values, int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(values, i + 1, j);

        // Return minimum of current and remaining.
        return (values[i].compareTo(values[k]) < 0)? i : k;
    }

    private void swap(int[] values, int first, int second) {
        int temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }

    private void swap(String[] values, int first, int second) {
        String temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }

    private void swap(T[] values, int first, int second) {
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }
}

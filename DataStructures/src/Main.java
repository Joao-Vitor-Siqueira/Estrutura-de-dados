import Algoritmos.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {49, 15, 40, 27, 20, 19, 50, 2, 12, 28, 49, 44, 9, 59, 18, 5, 30, 6, 7, 28};

        //BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.sort(arr, arr.length);

        //InsertionSort insertionSort = new InsertionSort();
        //insertionSort.sort(arr);

        //QuickSort quickSort = new QuickSort();
        //quickSort.sort(arr,0, arr.length - 1);
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]);
            if (i == arr.length - 1) break;
            System.out.print(",");
        }
        System.out.print("]\n");
    }
}




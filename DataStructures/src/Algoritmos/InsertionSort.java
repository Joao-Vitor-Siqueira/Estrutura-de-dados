package Algoritmos;

public class InsertionSort {
    public InsertionSort(){}
    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j --;
                printArr(arr);
            }
        }
    }
    private void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]);
            if (i == arr.length - 1) break;
            System.out.print(",");
        }
        System.out.print("]\n");
    }
}

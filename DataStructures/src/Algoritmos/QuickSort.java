package Algoritmos;

public class QuickSort {
    public QuickSort(){}
    //pivot = ultimo elemento do array
    public void sort(int[] arr,int low,int high){
        if(high <= low) return;
        int pivot = partition(arr,low,high);
        sort(arr,low,pivot - 1);
        sort(arr,pivot + 1,high);
    }
    private int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int j = low - 1;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot){
                j ++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        arr[high] = arr[j + 1];
        arr[j + 1] = pivot;
        printArr(arr);
        return j + 1;
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

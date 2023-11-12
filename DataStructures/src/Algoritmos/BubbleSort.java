package Algoritmos;

public class BubbleSort {
    public BubbleSort(){}
    public void sort(int[] arr,int size){
        printArr(arr);
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            int temp = arr[i];
            if(temp > arr[i + 1]){
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        sort(arr,size - 1);
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

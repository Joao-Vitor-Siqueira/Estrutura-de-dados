public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,4,7,1,3,9,6,5};
        quickSort(arr,0, arr.length - 1);
        printArr(arr);
    }
    public static void bubbleSort(int[] arr,int size){
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            int temp = arr[i];
            if(temp > arr[i + 1]){
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr,size - 1);
    }
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j --;
            }
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        if(high <= low) return;
        int pivot = partition(arr,low,high);
        quickSort(arr,low,pivot - 1);
        quickSort(arr,pivot + 1,high);
    }
    public static int partition(int[] arr,int low,int high){
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
        return j + 1;
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


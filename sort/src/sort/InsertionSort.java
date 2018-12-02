package sort;

public class InsertionSort {

    public static void insertionSort(int arr[]) {
        //从第二个数开始插入
        for (int i = 1; i < arr.length; i++) {
            //该数与前面形成的有序序列进行比较，该数较小的话就交换，直到插入合适位置，较大的话就不交换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

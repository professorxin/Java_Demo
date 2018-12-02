package sort;

import java.util.Arrays;

public class TestSort {
    //对数器，用来检测我写的排序算法是否正确

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxSize + 1) * Math.random()) - (int) (maxSize * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr1) {
        if (arr1 == null) return null;
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        return res;
    }

    public static void main(String args[]) {
        int testTime = 100;
        int maxSize = 100;
        int maxValue = 100;
        //boolean succeed = true;
/*        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            printArray(arr1);
            //调用系统的排序算法
            comparator(arr2);
            printArray(arr2);

            //排序算法
            HeapSort.heapSort(arr1);
            printArray(arr1);

            if (!isEqual(arr1,arr2)) {
                succeed = false;
                break;
            }
        }*/
        int[] arr1=new int[]{5,3,8};
        HeapSort.heapSort(arr1);
        printArray(arr1);
        //System.out.println(succeed == true ? "nice" : "bad");
    }
}

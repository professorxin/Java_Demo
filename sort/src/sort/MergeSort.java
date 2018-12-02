package sort;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int index, int end) {
        if (index == end) return;
        int mid = index + (end - index) / 2;
        mergeSort(arr, index, mid);
        mergeSort(arr, mid + 1, end);
        //合并两个数组
        merge(arr, index, mid, end);
    }

    public static void merge(int[] arr, int index, int mid, int end) {
        //构造辅助数组
        int[] help = new int[end - index + 1];
        int i = 0;
        int p1 = index;
        int p2 = mid + 1;
        //哪个比较小就放入辅助数组，并且移动指针
        while (p1 <= mid && p2 <= end) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //说明p2指针移动完毕，只剩p1
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        //说明p1指针移动完毕，只剩p2
        while (p2 <= end) {
            help[i++] = arr[p2++];
        }
        //将辅助数组的元素复制回原来数组
        for (int j = 0; j < help.length; j++) {
            arr[index + j] = help[j];
        }
    }
}

package sort;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int index, int end) {
        if (index < end) {
            //swap(arr, l + (int) (Math.random() * (r - l + 1)), r);（这一句加上就是随机快速排序，暂时不加）
            //p数组代表的是等于划分基准点的元素的初始和结束位置
            int[] p = partition(arr, index, end);
            quickSort(arr, index, p[0] - 1);
            quickSort(arr, p[1] + 1, end);
        }
    }

    //下面是以数组的最后一个元素作为基准点的，这个方法完成的结果就是小于基准点放左边，等于基准点放中间，大于基准点放右边
    public static int[] partition(int[] arr, int index, int end) {
        //less指针用来划分小于基准点的范围
        int less = index - 1;
        //more指针用来划分大于基准点的范围
        int more = end;
        while (index < more) {
            //如果当前元素小于基准点的元素，就让它与less指针的前一个数字交换，并移动less指针，移动index指针操作下一个数
            //如果当前元素大于基准点的元素，就让它与more指针的前一个数字交换，并移动more指针
            //如果当前元素等于基准点的元素，移动index指针操作下一个数
            if (arr[index] < arr[end]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[end]) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        //由于基准点的元素一直没有动过，最后要让它和大于基准点的元素交换
        swap(arr, more, end);
        //返回等于基准点元素的下标
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

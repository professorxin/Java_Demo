package sort;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //建立大顶堆的过程
    public static void heapInsert(int[] arr, int index) {
        //如果当前值大于父节点的话，与父节点交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //重新调整成为大顶堆的过程
    public static void heapify(int[] arr, int index, int size) {
        //取该结点的左结点
        int left = index * 2 + 1;
        //如果左结点在size范围内
        while (left < size) {
            //从左右结点中选出最大的，赋给largest
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //判断当前结点和左右结点的最大值比较，如果当前结点大就维持原样（因为调整到index的结点可能比左结点的值要大的）
            if (arr[largest]<arr[index]) {
                break;
            }
            //交换index和largest结点的值
            swap(arr, largest, index);
            //让index指针移动到largest结点位置
            index = largest;
            //取index的左结点
            left = index * 2 + 1;
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

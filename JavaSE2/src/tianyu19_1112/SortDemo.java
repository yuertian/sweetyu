package tianyu19_1112;


import java.util.Arrays;

public class SortDemo {
    //插入排序，升序为例
    public static void insertSort(int[] array) {
        //bound变量来把整个数组分成两个区间
        //[0, bound) 已排序区间
        //[bound, size) 待排序区间
        for (int bound = 1; bound < array.length; bound++) {
            //bound 下标对应的元素就是待插入元素
            //把这个元素放到前面的有序顺序表中的合适位置
            int tmp = array[bound];
            int cur = bound - 1;
            for (cur = bound - 1; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            //同组之内的相邻元素之间的下标相差gap
            for (cur = bound - gap; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        //[0, bound) 已排序区间
        //[cur, size) 待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        //[0, bound) 已排序区间
        //[cur, size) 待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    //堆排序（升序要建大堆，降序要建小堆）
    public static void heapSort(int[] array) {
        //1.创建堆
        createHeap(array);
        //2.循环取出堆顶的最大元素，放在最后面
        for (int i = 0; i < array.length; i++) {
            //待排序区间 [0, array.length - 1 - i)
            //已排序区间 [array.length - 1 - i, array.length - 1]
            swap(array, 0, array.length - 1 - i);
            //1)要调整的数组
            //2)起始位置
            //3)结束位置
            shiftDown(array, 0, array.length - 1 - i);
        }
    }

    //创建堆
    private static void createHeap(int[] array) {
            //从最后一个非叶子节点开始出发，从后往前向下调整
            for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
                shiftDown(array, i, array.length - 1);
            }
    }

    //O(logN)
    // 向下调整
    private static void shiftDown(int[] array, int index, int size) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }//此时 child 就指向左右子树较大的那一个
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        //参数的含义是需要排序的区间
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }//下标越界

        //找到一个基准值，左侧元素都比他小，右侧元素都比它大
        int baseIndex = partition(array, left, right);
        //再对基准值左侧的所有元素进行快速排序
        quickSortHelper(array, left, baseIndex - 1);
        //再对基准值右侧的所有元素进行快速排序
        quickSortHelper(array, baseIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseIndex = right;
        int baseValue = array[baseIndex];
        while (left < right) {
            while (left < right && array[left] <= baseValue) {
                left++;
            }//循环结束，left指向第一个比baseValue大的元素

            while (left < right && array[right] >= baseValue) {
                right--;
            }//循环结束，right指向第一个比baseValue大的元素

            //两个元素都找到，就进行交换
            swap(array, left, right);
        }//循环结束，left与right相遇，且相遇的这个元素一定比基准值大
        //两种情况导致循环结束：
        //1.left++：上一次循环结束，left和right进行了一次交换，交换后的right已经指向比基准值大的元素
        //2.right--：left与right相遇前，left已经指向一个比基准值大的元素了

        //让基准值与left/right（大于基准值）交换
        swap(array, left, baseIndex);//交换后，left左边的元素都小于基准值，右边元素都大于基准值
        return left;//返回基准值得下标
    }

    public static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {9, 5, 2, 7, 3, 6, 8, 1};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //heapSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

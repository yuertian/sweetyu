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
        creatHeap(array);
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

        private static void creatHeap(int[] array) {
            //从最后一个非叶子节点开始出发，从后往前向下调整
            for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
                shiftDown(array, i, array.length);
            }
        }

        //O(logN)
        private static void shiftDwon(int[] array, int index, int size) {
            int parent = index;
            int child = 2 * index + 1;
            while (child < size) {
                if (child + 1 < size && array[child + 1] > array[child]) {
                    child = child + 1;
                }//此时 child 就指向左右子树较大的那一个
                swap(array, child, parent);


                parent = child;
                child = 2 * index + 1;
            }

        }


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
        System.out.println(Arrays.toString(arr));
    }
}

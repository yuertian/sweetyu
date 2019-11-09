package tianyu19_1109;

public class Heap {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        crateHeap(array,8);
    }
    //向下调整，小堆为例
    public static void shiftDown(int[] array,int size, int index) {
        int left = 2 * index + 1;//当前节点左孩子的下标
        while (left < size) {
            int min = left;
            int right = 2 * index + 2;//当前节点有孩子的下标
            if (right < size) {
                if (array[rigth] < array[left]) {
                    //判断右孩子是否越界
                    //如果右孩子越界，min依然是left
                    min = right;
                }
                if (array[index] <= array[min]) {
                    break;//当前节点和他的子树已经是小堆
                }
                //交换index和min
                int tmp = array[index];
                array[index] = array[min];
                array[min] = tmp;
                //min位置堆得性质可能被破坏
                //需要把min视作index，向下继续调整
                index = min;
                //同时把新的index的左孩子更新为left
                left = 2 * index + 1;
            }
        }
    }

    public static void crateHeap(int array, int size) {
        //co从最后一个非叶子节点出发，
        //size - 1 表示最后一个元素的下标
        //再-1  再 /2 表示最后一个非叶子节点
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }

}

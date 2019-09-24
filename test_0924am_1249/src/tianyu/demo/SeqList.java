package tianyu.demo;


import java.util.Arrays;

public class SeqList {
    private int[] data = new int[10];
    private int size = 0; //表示有效元素个数

    //打印顺续表
    public void display() {
        //System.out.println(Arrays.toString(data));
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //在pos位新增元素
    public void add(int pos, int value) {
        //pos = size时相当于尾插
        if (pos < 0 || pos >size) {
            return;//pos 位置无效
        }
        //尾插，把要插入的元素放在最后一个有效元素后面
        if (pos == size) {
            this.data[pos] = value;
            this.size++;
            return;
        }
        //当前有效元素个数大于数组长度，内存不够，需要扩容
        //申请空间，把原有的数据拷进去
        if (this.size > this.data.length) {
            realloc();
        }

        for (int i = this.size; i > pos; i--){
            data[i] = data[i - 1];
        }
        this.data[pos] = value;
        this.size++;
    }

    //扩容方法   只在类内部调用，需要封装
    private void realloc() {
        //扩容策略根据实际问题场景的特点来决定具体是线性增长还是指数增长
        //让扩容的次数尽量减少
        int[] newData = new int[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    //查找方法
    //按位查找
    public void searchPos(int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("没有找到下标为" + pos +"的元素");
        } else {
            System.out.println("下标为" + pos +"的元素为：" + this.data[pos];);
        }
    }
    //按值查找
    public void searchNum(int value) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == value) {
                System.out.println(value + "的下标为：" + i);
                return;
            }
        }
        System.out.println("查找失败！");
    }

    //删减方法
    //按位删
    public void deletePos(int pos) {
        System.out.println("要删除的元素下标为：" + pos);
        if (pos < 0 || pos > size) {
            System.out.println("删除失败！下标无效");
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
        System.out.println("删除成功！");
    }
    //按值删
    public void deleteNum(int value) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == value){
                deleteNum(i);
            }
        }
    }
}


import java.util.Arrays;

class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    //通过构造函数设置节点的data值
    public LinkedNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    // 链表的头结点(第一个节点). 有了这个头结点之后
    // 就可以根据 next 把所有的剩下的元素都获取到
    private LinkedNode head = null;

    //头插
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        //先考虑空链表情况
        if (this.head == null) {
            this.head = node;
            return;
        }
        //非空链表，让要插入节点作为链表的头节点
        //节点的具体内容被封装，无法直接赋值
        //node.next = this.head;
        node.next = head;
        this.head = node;
        return;
    }

    //尾插
    public LinkedNode addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        //判断空链表情况，
        if ()
    }

    public void display() {
        //打印链表中的所有元素
        System.out.print("[");
        for (LinkedNode node = this.head;
             node != null; node = node.next){
            System.out.print(node.data);
            if (node.next != null) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

}

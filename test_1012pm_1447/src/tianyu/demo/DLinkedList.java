package tianyu.demo;

class DLinkedNode {//双向带环
    public int val = 0;
    public DLinkedNode prev = null;
    public DLinkedNode next = null;

    public DLinkedNode(int val) {
        this.val = val;
    }
}
public class DLinkedList {
    private DLinkedNode head = null;

    public DLinkedList() {
        head = new DLinkedNode(-1);//创建傀儡节点
        //带环
        head.next = head;
        head.prev = head;
    }

    //头插
    public void addFirst(int data) {
        //创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(data);
        DLinkedNode next = head.next;

        newNode.next = next;
        next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    //尾插
    public void addLast(int data) {
        DLinkedNode newNode = new DLinkedNode(data);
        //此节点在新节点的前面，新节点在head的前面
        DLinkedNode prev = head.prev;

        head.prev = newNode;
        newNode.next = head;
        prev.next = newNode;
        newNode.prev = prev;
    }

    public void addIndex(int index, int data) {
        int size = size();
        if (index < 0 || index >size) {
            return;
        }
        if (index == 0) {
            //头插
            addFirst(data);
            return;
        }
        if (index == size) {
            //尾插
            addLast(data);
            return;
        }
        //创建两个新的指针，分别指向要插入位置的前后节点
        DLinkedNode next = getPos(index);//要插入位置对应的节点
        DLinkedNode prev = next.prev;//要插入位置的前一个节点
        DLinkedNode newNode = new DlinkedNode(data);//要插入的节点
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
    }

    public int size() {
        int size = 0;
        for (DLinkedNode cur = head.next;
                cur != head; cur = cur.next) {
            size++;
        }
        return size;
    }

    public DLinkedNode getPos(int index) {
        //找到下标index对应的节点
        DLinkedNode cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}


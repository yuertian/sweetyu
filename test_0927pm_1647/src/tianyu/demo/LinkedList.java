package tianyu.demo;

class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    //通过构造函数设置节点的data值
    public LinkedNode(int data)
    {
        this.data = data;
    }

//    //通过构造方法设置节点的next
//    public LinkedNode(LinkedNode next) {
//        this.next = next;
//    }
}


public class LinkedList {
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
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            this.head = node;
            return;
        }
        LinkedNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意指定位置插入
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int size = getLength();
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == size) {
            addLast(elem);
            return;
        }
        //在指定位置插入元素，先找到当前节点的前一个节点
        LinkedNode prev = getNodePos(index - 1);
        node.next = prev.next;
        prev.next = node;
    }

    public int getLength() {
        int size = 0;
        for (LinkedNode node = this.head;
             node.next != null; node = node.next) {
            size++;
        }
        return size;
    }

    public LinkedNode getNodePos(int index) {
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //判断元素是否在链表中
    public boolean contains(int toFind) {
        for (LinkedNode node = this.head;
            node.next != null; node = node.next) {
            if (toFind == node.data){
                return true;
            }
        }
        return false;
    }

    //按值删除指定节点
    public void toRemoveNum(int toRemove) {
        //首先考虑空链表的情况
        if (this.head == null) {
            return;
        }
        //考虑要删的是头结点情况
        if (head.data == toRemove) {
            this.head = head.next;
            return;
        }
        //按值删，先找到要删节点的前一个节点
        LinkedNode prev = searchPrev(toRemove);
        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;

    }

    public LinkedNode searchPrev(int toRemove) {
        //判断是否为空链表
        if (this.head == null) {
            return null;
        }
        for (LinkedNode prev = this.head;
             prev.next != null; prev = prev.next) {
            if (toRemove == prev.next.data) {
                return prev;
            }
        }
        return null;
    }

    //按位删除
    public void toRemovePos(int index) {
        int size = getLength();
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            this.head = head.next;
            return;
        }
        LinkedNode prev = getNodePos(index - 1);
        LinkedNode node = prev.next;
        prev.next = node.next;
    }

    public void toRemoveAll(int toRemove) {
        //先处理链表为空的情况
        if (this.head == null) {
            return;
        }
        //要找到删除节点的前一个节点
        LinkedNode prev = head;
        LinkedNode cur = prev.next;
        while (cur != null) {
            if (cur.data == toRemove) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //最后处理头节点
        if (head.data == toRemove) {
            this.head = head.next;
            return;
        }

    }

    public LinkedNode reversrList() {
        LinkedNode cur = head;
        LinkedNode prev = null;
        while (cur != null) {
            LinkedNode tempNext = cur.next;
            cur.next = prev;
            cur = tempNext;
        }
        return prev;
    }

    public LinkedNode middleNode() {
        LinkedNode cur = head;
        LinkedNode prev = head;
        while (cur != null || cur.next != null) {
            cur = cur.next.next;
            prev = prev.next;
        }
        return prev;
    }

    public LinkedNode FindKthToTail(int k) {
        int size = getLength();
        LinkedNode cur = head;
        LinkedNode prev = head;
        int steps = size - k;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        return prev;
    }

    public void display() {
        //打印链表中的所有元素
        System.out.print("[");
        for(LinkedNode node = this.head;
             node != null; node = node.next){
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}

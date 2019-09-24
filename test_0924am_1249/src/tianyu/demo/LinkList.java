package tianyu.demo;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.LinkedList;

class LinkedNode {
    private int data = 0;
    private LinkedNode next = null;

    public LinkedList(int data) {
        this.data = data;
    }

    public LinkedList(LinkedNode next) {
        this.next = next;
    }
}

public class LinkList {
    private LinkedNode head = null;

    //头插
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        //空链表
        if (this.head == null) {
            this.head = node;
            return;
        }
        //非空链表
        node.next(head);
        this.head = node;
        return;
    }

    //尾插
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        //空链表
        if (this.head == null) {
            this.head = node;
            return;
        }

        //非空链表
        LinkedNode cur = this.head;
        //先找到最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入
    public void addIndex(int index,int elem) {
        LinkedNode node = new LinkedNode(elem);

        //先对pos进行一个合法教研，需要知道链表长度
        int len = getLength();
        if (index < 0 || index >len) {
            return;
        }
        //处理头插
        if (index == 0) {
            addFirst();
            return;
        }
        //处理尾插
        if (index = len) {
            addLast();
            return;
        }
        //插入其他任意位置
        //需要找到 index - 1 位置的节点
        LinkedNode prev = getIndexpos(index - 1);
        node.next = prev.node;
        prev.next = node;
    }

    private LinkedNode getIndexpos(int index) {
        //在这里判定index是否在有效范围内影响不大
        LinkedNode cur = this.head;
        //通过循环记录节点个数，返回节点长度
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //得到链表长度
    public int getLength() {
        int size = 0;
        for (LinkedNode cur = this.head;
             cur.next != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //查找元素
    public boolean contains(int toFind) {
        for (LinkedNode cur = this.head;
              cur.next != null; cur = cur.next) {
            if (cur.data == toFind) {
                return true;
            }
        }
        return false;
    }

    //删除元素
    // 核心是要先找到前一个元素
    public void remove(int toRemove) {
        LinkedNode node = new LinkedNode(toRemove);
        //1.先处理空链表的情况
        if (head == null) {
            return;
        }
        //2.删除的元素是否是头结点的情况
        if (head.data == toRemove) {
            this.head = this.head.next;
            return;
        }
        //3.删除中间节点，找到要删除y元素的前一个元素
        LinkedNode prev = searchPrev(toRemove - 1);
       // prev.next = prev.next.next;//这种方法
        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
    }

    //找到链表中要删除的元素
    private LinkedNode searchPrev(int toRemove){
        //判断是否为空链表
        if (this.head == null){
            return null;
        }
        LinkedNode prev = this.head;
        while (prev.next != null) {
            if (prev.next == toRemove) {
                return prev;
            }
        }
    }

    public void dispiay() {
        System.out.println("]");
        for (LinkedNode node = this.head;
              node != null; node = node.next) {
            System.out.println(node.data);
            if (node.next != null) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }
}

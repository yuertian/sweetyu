package tianyu.demo;

public class Test{
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemoveNum();
        testRemovePos();
        testToRemoveAll();
        testReverse();
        testMiddleNode();
        testFindKthToTail();
    }

    public static void testAddFirst() {
        LinkedList list=new LinkedList();
        System.out.println("测试头插：");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.display();
    }

    public static void testAddLast() {
        LinkedList list = new LinkedList();
        System.out.println("测试尾插：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
    }

    public static void testAddIndex() {
        LinkedList list = new LinkedList();
        System.out.println("测试任意位置插入：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        list.addIndex(3,9);
        list.display();
    }

    public static void testContains() {
        LinkedList list = new LinkedList();
        System.out.println("测试链表中是否存在某元素：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("理想结果是false，实际结果是" + list.contains(6));
        System.out.println("理想结果是true，实际结果是" + list.contains(5));
    }

    public static void testRemoveNum() {
        LinkedList list = new LinkedList();
        System.out.println("测试按值删除：");
        System.out.println("删除前：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.println("删除后：");
        list.toRemoveNum(3);
        list.display();
    }

    public static void testRemovePos() {
        LinkedList list = new LinkedList();
        System.out.println("测试按位删除：");
        System.out.print("删除前：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.print("删除后：");
        list.toRemovePos(3) ;
        list.display();
    }

    public static void testToRemoveAll() {
        LinkedList list = new LinkedList();
        System.out.println("测试删除所有与指定元素相同的元素：");
        System.out.print("删除前：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(1);
        list.addLast(5);
        list.display();
        System.out.print("删除后：");
        list.toRemoveAll(1);
        list.display();
    }

    public static void testReverse() {
        LinkedList list = new LinkedList();
        System.out.println("测试逆置单链表：");
        System.out.println("逆置前：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.println("逆置后：");
        list.reverseList();
        list.display();
    }

    public static void testMiddleNode() {
        LinkedList list = new LinkedList();
        System.out.println("测试找到链表中间节点：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.println(list.middleNode());
    }

    public static void testFindKthToTail() {
        LinkedList list = new LinkedList();
        System.out.println("测试找到倒数第K个节点：");
        System.out.print("链表为：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        System.out.println(list.FindKthToTail(3));
    }
}


// 等价类划分：
//           每一种类别的测十数据中，跳出里两个典型的测试
//插入测试：
//1.选择一个非法坐标
//2.选择0号下标
//3.选择和size一样长的下标



//删除测试
//1.空链表
//2/

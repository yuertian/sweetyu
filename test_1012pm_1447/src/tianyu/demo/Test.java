package tianyu.demo;

public class Test {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
        testRemoveAll();
        testClear();
    }

    public static void testAddFirst(){
        DLinkedList list = new DLinkedList();
        System.out.println("头插：");
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
    }

    public static void testAddLast(){
        DLinkedList list = new DLinkedList();
        System.out.println("尾插：");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
    }

    public static void testAddIndex(){
        DLinkedList list = new DLinkedList();
        System.out.println("按位插：");
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        System.out.println("在下标3插入9：");
        list.addIndex(3,9);
        list.display();
    }

    public static void testContains(){
        DLinkedList list = new DLinkedList();
        System.out.println("查询：");
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        System.out.print("查询链表中是否有 9 ：");
        System.out.println(list.contains(9));
        System.out.print("查询链表中是否有 3 ：");
        System.out.println(list.contains(3));
    }

    public static void testRemove(){
        DLinkedList list = new DLinkedList();
        System.out.println("删除 3 ：");
        System.out.println("删除前：");
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        list.remove(3);
        System.out.println("删除后：");
        list.display();
    }

    public static void testRemoveAll(){
        DLinkedList list = new DLinkedList();
        System.out.println("删除所有的2 ：");
        System.out.println("删除前：");
        list.addFirst(5);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        list.removeAll(2);
        System.out.println("删除后：");
        list.display();
    }

    public static void testClear(){
        DLinkedList list = new DLinkedList();
        System.out.println("清空前：");
        list.addFirst(5);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        list.clear();
        System.out.println("清空后：");
        list.display();
    }
}

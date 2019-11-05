package tianyu.demo;

public class Test {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
    }

    public static void testAddFirst(){
        DLinkedList.addFirst(5);
        DLinkedList.addFirst(4);
        DLinkedList.addFirst(3);
        DLinkedList.addFirst(2);
        DLinkedList.addFirst(1);

    }
}

package test_2020_0725;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    // 1.逆置链表指向
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode node = head;

        while (node.next != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node.next = pre;
        return node;
    }

    // 2.头插法逆置
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;// new一个新链表
        while (head != null) {
            // 1.先从原链表中去掉第一个节点
            ListNode p = head;
            head = head.next;

            // 2.再将P节点头插到新链表
            p.next = newHead;
            newHead = p;
        }
        return newHead;
    }
}

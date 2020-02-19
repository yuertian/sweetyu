package nowCoder;

class ListNode {
    public int val;
    public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (newHead == null) {
                    newHead = list1;
                    newTail = newHead;
                } else {
                    newTail.next = list1;
                    newTail = newTail.next;
                }
                list1 = list1.next;
            } else {
                if (newHead == null) {
                    newHead = list2;
                    newTail = newHead;
                } else {
                    newTail.next = list2;
                    newTail = newTail.next;
                }
                list2 = list2.next;
            }
        }//循环结束，一定有一个链表为null
        if (list1 == null) {
            newTail.next = list2;
        } else {
            newTail.next = list1;
        }
        return newHead;
    }
}
